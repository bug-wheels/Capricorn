package com.github.bw.capricorn.commons;

import java.util.HashMap;
import java.util.Map;

public class DefaultServiceInstance implements ServiceInstance {

  private String instanceId;

  private String serviceId;

  private String host;

  private int port;

  private Map<String, String> metadata;

  public DefaultServiceInstance() {
    metadata = new HashMap<>();
  }

  public DefaultServiceInstance(String instanceId) {
    this.instanceId = instanceId;
    metadata = new HashMap<>();
  }

  @Override
  public Map<String, String> getMetadata() {
    return metadata;
  }

  @Override
  public String getInstanceId() {
    return instanceId;
  }

  @Override
  public String getServiceId() {
    return serviceId;
  }

  @Override
  public String getHost() {
    return host;
  }

  @Override
  public int getPort() {
    return port;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }
}
