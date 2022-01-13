package com.github.bw.capricorn.commons;

public class Registration {

  private String datacenter;
  private String namespace;
  private ServiceInstance serviceInstance;

  public Registration() {
  }

  public Registration(String datacenter, String namespace,
      ServiceInstance serviceInstance) {
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

  public void setServiceInstance(ServiceInstance serviceInstance) {
    this.serviceInstance = serviceInstance;
  }
}
