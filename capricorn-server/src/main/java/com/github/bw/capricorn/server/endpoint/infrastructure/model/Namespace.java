package com.github.bw.capricorn.server.endpoint.infrastructure.model;

import java.util.Date;
import javax.annotation.Generated;

public class Namespace {

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private Integer id;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private Integer dcId;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private String name;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private String description;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private Date createTime;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private Date updateTime;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public Integer getId() {
    return id;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public void setId(Integer id) {
    this.id = id;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public Integer getDcId() {
    return dcId;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public void setDcId(Integer dcId) {
    this.dcId = dcId;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public String getName() {
    return name;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public void setName(String name) {
    this.name = name;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public String getDescription() {
    return description;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public void setDescription(String description) {
    this.description = description;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public Date getCreateTime() {
    return createTime;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public Date getUpdateTime() {
    return updateTime;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}