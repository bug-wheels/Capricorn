package com.github.bw.capricorn.server.endpoint;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.bw.capricorn.commons.DefaultServiceInstance;
import com.github.bw.capricorn.commons.Registration;
import com.github.bw.capricorn.commons.ServiceInstance;
import com.github.bw.capricorn.commons.response.InstanceHealthStatus;
import com.github.bw.capricorn.server.endpoint.infrastructure.mapper.DatacenterDynamicSqlSupport;
import com.github.bw.capricorn.server.endpoint.infrastructure.mapper.DatacenterMapper;
import com.github.bw.capricorn.server.endpoint.infrastructure.mapper.NamespaceDynamicSqlSupport;
import com.github.bw.capricorn.server.endpoint.infrastructure.mapper.NamespaceMapper;
import com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceDynamicSqlSupport;
import com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceMapper;
import com.github.bw.capricorn.server.endpoint.infrastructure.model.Datacenter;
import com.github.bw.capricorn.server.endpoint.infrastructure.model.Namespace;
import com.github.bw.capricorn.server.endpoint.util.Preconditions;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.sql.DataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBatisServerServiceRegistry implements DiscoveryRegistry<Registration> {

  private static final Logger logger = LoggerFactory.getLogger(MyBatisServerServiceRegistry.class);

  private final SqlSessionFactory sqlSessionFactory;

  public MyBatisServerServiceRegistry(DataSource dataSource) {
    TransactionFactory transactionFactory = new JdbcTransactionFactory();
    Environment environment = new Environment("capricorn", transactionFactory, dataSource);
    Configuration configuration = new Configuration(environment);
    configuration.addMapper(DatacenterMapper.class);
    configuration.addMapper(NamespaceMapper.class);
    configuration.addMapper(ServiceInstanceMapper.class);
    this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
  }

  @Override
  public void register(Registration registration) {
    try (SqlSession session = sqlSessionFactory.openSession()) {
      DatacenterMapper datacenterMapper = session.getMapper(DatacenterMapper.class);
      NamespaceMapper namespaceMapper = session.getMapper(NamespaceMapper.class);
      ServiceInstanceMapper serviceInstanceMapper = session.getMapper(ServiceInstanceMapper.class);

      Optional<Datacenter> datacenter = datacenterMapper.selectOne(
          c -> c.where(DatacenterDynamicSqlSupport.name, SqlBuilder.isEqualTo(registration.getDatacenter())));
      Preconditions.checkArgument(datacenter.isPresent(), "datacenter 不存在");

      int dcId = datacenter.get().getId();

      Optional<Namespace> namespace = namespaceMapper.selectOne(
          c -> c.where(NamespaceDynamicSqlSupport.name, SqlBuilder.isEqualTo(registration.getNamespace()),
              SqlBuilder.and(NamespaceDynamicSqlSupport.dcId, SqlBuilder.isEqualTo(dcId))));
      Preconditions.checkArgument(namespace.isPresent(), "namespace 不存在");

      int nsId = namespace.get().getId();

      Date now = new Date();

      // TODO 此处应该先校验存在不存在，不存在才能插入记录

      com.github.bw.capricorn.server.endpoint.infrastructure.model.ServiceInstance serviceInstance = new com.github.bw.capricorn.server.endpoint.infrastructure.model.ServiceInstance();
      serviceInstance.setDcId(dcId);
      serviceInstance.setNsId(nsId);
      serviceInstance.setServiceId(registration.getServiceInstance().getServiceId());
      serviceInstance.setHost(registration.getServiceInstance().getHost());
      serviceInstance.setPort(registration.getServiceInstance().getPort());
      serviceInstance.setMetadata(JSON.toJSONString(registration.getServiceInstance().getMetadata()));
      serviceInstance.setLastHeartbeatTime(now);
      serviceInstance.setCreateTime(now);
      serviceInstance.setUpdateTime(now);
      serviceInstanceMapper.insertSelective(serviceInstance);
      session.commit();
    } catch (Exception e) {
      logger.error("剔除服务信息异常 Registration:{}", registration, e);
      throw e;
    }
  }

  @Override
  public void deregister(Registration registration) {
    try (SqlSession session = sqlSessionFactory.openSession()) {
      DatacenterMapper datacenterMapper = session.getMapper(DatacenterMapper.class);
      NamespaceMapper namespaceMapper = session.getMapper(NamespaceMapper.class);
      ServiceInstanceMapper serviceInstanceMapper = session.getMapper(ServiceInstanceMapper.class);

      Optional<Datacenter> datacenter = datacenterMapper.selectOne(
          c -> c.where(DatacenterDynamicSqlSupport.name, SqlBuilder.isEqualTo(registration.getDatacenter())));
      Preconditions.checkArgument(datacenter.isPresent(), "datacenter 不存在");

      int dcId = datacenter.get().getId();

      Optional<Namespace> namespace = namespaceMapper.selectOne(
          c -> c.where(NamespaceDynamicSqlSupport.name, SqlBuilder.isEqualTo(registration.getNamespace()),
              SqlBuilder.and(NamespaceDynamicSqlSupport.dcId, SqlBuilder.isEqualTo(dcId))));
      Preconditions.checkArgument(namespace.isPresent(), "namespace 不存在");

      int nsId = namespace.get().getId();

      serviceInstanceMapper.delete(c -> c.where(ServiceInstanceDynamicSqlSupport.dcId, SqlBuilder.isEqualTo(dcId),
          SqlBuilder.and(ServiceInstanceDynamicSqlSupport.nsId, SqlBuilder.isEqualTo(nsId)),
          SqlBuilder.and(ServiceInstanceDynamicSqlSupport.instanceId,
              SqlBuilder.isEqualTo(registration.getServiceInstance().getInstanceId()))));
      session.commit();
    } catch (Exception e) {
      logger.error("剔除服务信息异常 Registration:{}", registration, e);
      throw e;
    }
  }

  @Override
  public void setStatus(Registration registration, String status) {

  }

  @Override
  public <T> T getStatus(Registration registration) {
    return null;
  }

  /**
   * 查询实例
   * <p>
   * 返回从数据库查询到的数据
   * <p>
   * PS: 这个其实一条 SQL 就完成了，不过不太喜欢写 SQL, 就写成了这个形式，写法还凑合
   *
   * @param dc                   数据中心
   * @param ns                   ns
   * @param serviceId            服务名
   * @param instanceHealthStatus 健康状态
   */
  @Override
  public List<ServiceInstance> instances(String dc, String ns, String serviceId,
      InstanceHealthStatus instanceHealthStatus) {

    try (SqlSession session = sqlSessionFactory.openSession()) {
      DatacenterMapper datacenterMapper = session.getMapper(DatacenterMapper.class);
      NamespaceMapper namespaceMapper = session.getMapper(NamespaceMapper.class);
      ServiceInstanceMapper serviceInstanceMapper = session.getMapper(ServiceInstanceMapper.class);

      Optional<Datacenter> datacenter = datacenterMapper.selectOne(
          c -> c.where(DatacenterDynamicSqlSupport.name, SqlBuilder.isEqualTo(dc)));
      Preconditions.checkArgument(datacenter.isPresent(), "datacenter 不存在");

      int dcId = datacenter.get().getId();

      Optional<Namespace> namespace = namespaceMapper.selectOne(
          c -> c.where(NamespaceDynamicSqlSupport.name, SqlBuilder.isEqualTo(ns),
              SqlBuilder.and(NamespaceDynamicSqlSupport.dcId, SqlBuilder.isEqualTo(dcId))));
      Preconditions.checkArgument(namespace.isPresent(), "namespace 不存在");

      int nsId = namespace.get().getId();

      return serviceInstanceMapper.select(
              c -> c.where(ServiceInstanceDynamicSqlSupport.dcId, SqlBuilder.isEqualTo(dcId),
                  SqlBuilder.and(ServiceInstanceDynamicSqlSupport.nsId, SqlBuilder.isEqualTo(nsId)),
                  SqlBuilder.and(ServiceInstanceDynamicSqlSupport.serviceId, SqlBuilder.isEqualTo(serviceId))))
          .stream()
          .map(it -> {
            DefaultServiceInstance defaultServiceInstance = new DefaultServiceInstance();
            defaultServiceInstance.setInstanceId(it.getInstanceId());
            defaultServiceInstance.setServiceId(it.getServiceId());
            defaultServiceInstance.setHost(it.getHost());
            defaultServiceInstance.setPort(it.getPort());
            defaultServiceInstance.setMetadata(
                JSON.parseObject(it.getMetadata(), new TypeReference<HashMap<String, String>>() {
                }));
            return defaultServiceInstance;
          }).collect(Collectors.toList());
    } catch (Exception e) {
      logger.error("查询服务信息异常 dc:{}, ns:{}, serviceId:{}", dc, ns, serviceId, e);
    }

    return null;
  }
}
