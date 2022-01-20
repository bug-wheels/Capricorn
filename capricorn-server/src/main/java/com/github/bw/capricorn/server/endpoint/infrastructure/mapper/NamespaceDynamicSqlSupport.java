package com.github.bw.capricorn.server.endpoint.infrastructure.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class NamespaceDynamicSqlSupport {

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final Namespace namespace = new Namespace();

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<Integer> id = namespace.id;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<Integer> dcId = namespace.dcId;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<String> name = namespace.name;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<String> description = namespace.description;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<Date> createTime = namespace.createTime;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final SqlColumn<Date> updateTime = namespace.updateTime;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public static final class Namespace extends SqlTable {

    public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

    public final SqlColumn<Integer> dcId = column("dc_id", JDBCType.INTEGER);

    public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

    public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

    public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

    public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

    public Namespace() {
      super("namespace");
    }
  }
}