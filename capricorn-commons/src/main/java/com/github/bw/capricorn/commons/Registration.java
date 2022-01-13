package com.github.bw.capricorn.commons;

public class Registration {

  private String datacenter;
  private String namespace;
  private DefaultServiceInstance serviceInstance;

  public Registration() {
  }

  public Registration(String datacenter, String namespace,
      DefaultServiceInstance serviceInstance) {
    this.datacenter = datacenter;
    this.namespace = namespace;
    this.serviceInstance = serviceInstance;
  }

  public String getDatacenter() {
    return datacenter;
  }

  public void setDatacenter(String datacenter) {
    this.datacenter = datacenter;
  }

  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public ServiceInstance getServiceInstance() {
    return serviceInstance;
  }

  public void setServiceInstance(DefaultServiceInstance serviceInstance) {
    this.serviceInstance = serviceInstance;
  }
}
