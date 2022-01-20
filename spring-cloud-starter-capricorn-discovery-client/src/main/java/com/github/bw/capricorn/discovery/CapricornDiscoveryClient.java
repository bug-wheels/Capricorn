package com.github.bw.capricorn.discovery;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

public class CapricornDiscoveryClient implements DiscoveryClient {

  @Override
  public String description() {
    return "CapricornDiscoveryClient";
  }

  @Override
  public List<ServiceInstance> getInstances(String serviceId) {
    return null;
  }

  @Override
  public List<String> getServices() {
    return null;
  }
}
