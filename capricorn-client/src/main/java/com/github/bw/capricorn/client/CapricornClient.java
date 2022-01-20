package com.github.bw.capricorn.client;

import com.github.bw.capricorn.client.util.ClientGenerator;
import com.github.bw.capricorn.commons.Registration;
import com.github.bw.capricorn.commons.ServiceInstance;
import java.util.List;

public class CapricornClient {

  private CapricornApiClient capricornApiClient;

  protected CapricornClient(CapricornApiClient capricornApiClient) {
    this.capricornApiClient = capricornApiClient;
  }

  public void register(Registration registration) {
    ClientGenerator.executeSync(capricornApiClient.register(registration));
  }

  public void deregister(String datacenter, String namespace, String instanceId) {
    ClientGenerator.executeSync(capricornApiClient.deregister(datacenter, namespace, instanceId));
  }

  public List<ServiceInstance> instances(String datacenter, String namespace, String serviceId) {
    return ClientGenerator.executeSync(capricornApiClient.instances(datacenter, namespace, serviceId)).getInstances();
  }
}
