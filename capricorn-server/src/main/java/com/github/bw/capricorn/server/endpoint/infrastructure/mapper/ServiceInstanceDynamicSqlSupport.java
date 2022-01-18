package com.github.bw.capricorn.server.endpoint.infrastructure.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ServiceInstanceDynamicSqlSupport {

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final ServiceInstance serviceInstance = new ServiceInstance();

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<Integer> id = serviceInstance.id;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<Integer> dcId = serviceInstance.dcId;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<Integer> nsId = serviceInstance.nsId;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<String> instanceId = serviceInstance.instanceId;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<String> serviceId = serviceInstance.serviceId;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<String> host = serviceInstance.host;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<Short> port = serviceInstance.port;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<String> metadata = serviceInstance.metadata;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<Date> lastHeartbeatTime = serviceInstance.lastHeartbeatTime;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<Date> createTime = serviceInstance.createTime;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<Date> updateTime = serviceInstance.updateTime;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final class ServiceInstance extends SqlTable {

    public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

    public final SqlColumn<Integer> dcId = column("dc_id", JDBCType.INTEGER);

    public final SqlColumn<Integer> nsId = column("ns_id", JDBCType.INTEGER);

    public final SqlColumn<String> instanceId = column("instance_id", JDBCType.VARCHAR);

    public final SqlColumn<String> serviceId = column("service_id", JDBCType.VARCHAR);

    public final SqlColumn<String> host = column("`host`", JDBCType.VARCHAR);

    public final SqlColumn<Short> port = column("port", JDBCType.SMALLINT);

    public final SqlColumn<String> metadata = column("metadata", JDBCType.VARCHAR);

    public final SqlColumn<Date> lastHeartbeatTime = column("last_heartbeat_time", JDBCType.TIMESTAMP);

    public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

    public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

    public ServiceInstance() {
      super("service_instance");
    }
  }
}