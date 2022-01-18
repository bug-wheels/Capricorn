package com.github.bw.capricorn.server.endpoint.infrastructure.mapper;

import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceDynamicSqlSupport.createTime;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceDynamicSqlSupport.dcId;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceDynamicSqlSupport.host;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceDynamicSqlSupport.id;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceDynamicSqlSupport.instanceId;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceDynamicSqlSupport.lastHeartbeatTime;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceDynamicSqlSupport.metadata;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceDynamicSqlSupport.nsId;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceDynamicSqlSupport.port;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceDynamicSqlSupport.serviceId;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceDynamicSqlSupport.serviceInstance;
import static com.github.bw.capricorn.server.endpoint.infrastructure.mapper.ServiceInstanceDynamicSqlSupport.updateTime;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.github.bw.capricorn.server.endpoint.infrastructure.model.ServiceInstance;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface ServiceInstanceMapper {

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  BasicColumn[] selectList = BasicColumn.columnList(id, dcId, nsId, instanceId, serviceId, host, port, metadata,
      lastHeartbeatTime, createTime, updateTime);

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  @SelectProvider(type = SqlProviderAdapter.class, method = "select")
  long count(SelectStatementProvider selectStatement);

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
  int delete(DeleteStatementProvider deleteStatement);

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
  int insert(InsertStatementProvider<ServiceInstance> insertStatement);

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
  int insertMultiple(MultiRowInsertStatementProvider<ServiceInstance> multipleInsertStatement);

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  @SelectProvider(type = SqlProviderAdapter.class, method = "select")
  @ResultMap("ServiceInstanceResult")
  Optional<ServiceInstance> selectOne(SelectStatementProvider selectStatement);

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  @SelectProvider(type = SqlProviderAdapter.class, method = "select")
  @Results(id = "ServiceInstanceResult", value = {
      @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
      @Result(column = "dc_id", property = "dcId", jdbcType = JdbcType.INTEGER),
      @Result(column = "ns_id", property = "nsId", jdbcType = JdbcType.INTEGER),
      @Result(column = "instance_id", property = "instanceId", jdbcType = JdbcType.VARCHAR),
      @Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.VARCHAR),
      @Result(column = "host", property = "host", jdbcType = JdbcType.VARCHAR),
      @Result(column = "port", property = "port", jdbcType = JdbcType.SMALLINT),
      @Result(column = "metadata", property = "metadata", jdbcType = JdbcType.VARCHAR),
      @Result(column = "last_heartbeat_time", property = "lastHeartbeatTime", jdbcType = JdbcType.TIMESTAMP),
      @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
      @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
  })
  List<ServiceInstance> selectMany(SelectStatementProvider selectStatement);

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
  int update(UpdateStatementProvider updateStatement);

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  default long count(CountDSLCompleter completer) {
    return MyBatis3Utils.countFrom(this::count, serviceInstance, completer);
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  default int delete(DeleteDSLCompleter completer) {
    return MyBatis3Utils.deleteFrom(this::delete, serviceInstance, completer);
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  default int deleteByPrimaryKey(Integer id_) {
    return delete(c ->
        c.where(id, isEqualTo(id_))
    );
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  default int insert(ServiceInstance record) {
    return MyBatis3Utils.insert(this::insert, record, serviceInstance, c ->
        c.map(id).toProperty("id")
            .map(dcId).toProperty("dcId")
            .map(nsId).toProperty("nsId")
            .map(instanceId).toProperty("instanceId")
            .map(serviceId).toProperty("serviceId")
            .map(host).toProperty("host")
            .map(port).toProperty("port")
            .map(metadata).toProperty("metadata")
            .map(lastHeartbeatTime).toProperty("lastHeartbeatTime")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
    );
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  default int insertMultiple(Collection<ServiceInstance> records) {
    return MyBatis3Utils.insertMultiple(this::insertMultiple, records, serviceInstance, c ->
        c.map(id).toProperty("id")
            .map(dcId).toProperty("dcId")
            .map(nsId).toProperty("nsId")
            .map(instanceId).toProperty("instanceId")
            .map(serviceId).toProperty("serviceId")
            .map(host).toProperty("host")
            .map(port).toProperty("port")
            .map(metadata).toProperty("metadata")
            .map(lastHeartbeatTime).toProperty("lastHeartbeatTime")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
    );
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  default int insertSelective(ServiceInstance record) {
    return MyBatis3Utils.insert(this::insert, record, serviceInstance, c ->
        c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(dcId).toPropertyWhenPresent("dcId", record::getDcId)
            .map(nsId).toPropertyWhenPresent("nsId", record::getNsId)
            .map(instanceId).toPropertyWhenPresent("instanceId", record::getInstanceId)
            .map(serviceId).toPropertyWhenPresent("serviceId", record::getServiceId)
            .map(host).toPropertyWhenPresent("host", record::getHost)
            .map(port).toPropertyWhenPresent("port", record::getPort)
            .map(metadata).toPropertyWhenPresent("metadata", record::getMetadata)
            .map(lastHeartbeatTime).toPropertyWhenPresent("lastHeartbeatTime", record::getLastHeartbeatTime)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
    );
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  default Optional<ServiceInstance> selectOne(SelectDSLCompleter completer) {
    return MyBatis3Utils.selectOne(this::selectOne, selectList, serviceInstance, completer);
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  default List<ServiceInstance> select(SelectDSLCompleter completer) {
    return MyBatis3Utils.selectList(this::selectMany, selectList, serviceInstance, completer);
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  default List<ServiceInstance> selectDistinct(SelectDSLCompleter completer) {
    return MyBatis3Utils.selectDistinct(this::selectMany, selectList, serviceInstance, completer);
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  default Optional<ServiceInstance> selectByPrimaryKey(Integer id_) {
    return selectOne(c ->
        c.where(id, isEqualTo(id_))
    );
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  default int update(UpdateDSLCompleter completer) {
    return MyBatis3Utils.update(this::update, serviceInstance, completer);
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  static UpdateDSL<UpdateModel> updateAllColumns(ServiceInstance record, UpdateDSL<UpdateModel> dsl) {
    return dsl.set(id).equalTo(record::getId)
        .set(dcId).equalTo(record::getDcId)
        .set(nsId).equalTo(record::getNsId)
        .set(instanceId).equalTo(record::getInstanceId)
        .set(serviceId).equalTo(record::getServiceId)
        .set(host).equalTo(record::getHost)
        .set(port).equalTo(record::getPort)
        .set(metadata).equalTo(record::getMetadata)
        .set(lastHeartbeatTime).equalTo(record::getLastHeartbeatTime)
        .set(createTime).equalTo(record::getCreateTime)
        .set(updateTime).equalTo(record::getUpdateTime);
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  static UpdateDSL<UpdateModel> updateSelectiveColumns(ServiceInstance record, UpdateDSL<UpdateModel> dsl) {
    return dsl.set(id).equalToWhenPresent(record::getId)
        .set(dcId).equalToWhenPresent(record::getDcId)
        .set(nsId).equalToWhenPresent(record::getNsId)
        .set(instanceId).equalToWhenPresent(record::getInstanceId)
        .set(serviceId).equalToWhenPresent(record::getServiceId)
        .set(host).equalToWhenPresent(record::getHost)
        .set(port).equalToWhenPresent(record::getPort)
        .set(metadata).equalToWhenPresent(record::getMetadata)
        .set(lastHeartbeatTime).equalToWhenPresent(record::getLastHeartbeatTime)
        .set(createTime).equalToWhenPresent(record::getCreateTime)
        .set(updateTime).equalToWhenPresent(record::getUpdateTime);
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  default int updateByPrimaryKey(ServiceInstance record) {
    return update(c ->
        c.set(dcId).equalTo(record::getDcId)
            .set(nsId).equalTo(record::getNsId)
            .set(instanceId).equalTo(record::getInstanceId)
            .set(serviceId).equalTo(record::getServiceId)
            .set(host).equalTo(record::getHost)
            .set(port).equalTo(record::getPort)
            .set(metadata).equalTo(record::getMetadata)
            .set(lastHeartbeatTime).equalTo(record::getLastHeartbeatTime)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
    );
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  default int updateByPrimaryKeySelective(ServiceInstance record) {
    return update(c ->
        c.set(dcId).equalToWhenPresent(record::getDcId)
            .set(nsId).equalToWhenPresent(record::getNsId)
            .set(instanceId).equalToWhenPresent(record::getInstanceId)
            .set(serviceId).equalToWhenPresent(record::getServiceId)
            .set(host).equalToWhenPresent(record::getHost)
            .set(port).equalToWhenPresent(record::getPort)
            .set(metadata).equalToWhenPresent(record::getMetadata)
            .set(lastHeartbeatTime).equalToWhenPresent(record::getLastHeartbeatTime)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
    );
  }
}