package com.github.bw.capricorn.server.endpoint.infrastructure.model;

import java.util.Date;
import javax.annotation.Generated;

public class ServiceInstance {

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private Integer id;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private Integer dcId;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private Integer nsId;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private String instanceId;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private String serviceId;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private String host;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private Integer port;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private String metadata;

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  private Date lastHeartbeatTime;

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
  public Integer getNsId() {
    return nsId;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public void setNsId(Integer nsId) {
    this.nsId = nsId;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public String getInstanceId() {
    return instanceId;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public String getServiceId() {
    return serviceId;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public String getHost() {
    return host;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public void setHost(String host) {
    this.host = host;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public Integer getPort() {
    return port;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public void setPort(Integer port) {
    this.port = port;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public String getMetadata() {
    return metadata;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public void setMetadata(String metadata) {
    this.metadata = metadata;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public Date getLastHeartbeatTime() {
    return lastHeartbeatTime;
  }

  @Generated("org.mybatis.generator.api.MyBatisGenerator")
  public void setLastHeartbeatTime(Date lastHeartbeatTime) {
    this.lastHeartbeatTime = lastHeartbeatTime;
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