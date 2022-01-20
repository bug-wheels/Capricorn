package com.github.bw.capricorn.commons.response;

import com.github.bw.capricorn.commons.ServiceInstance;
import java.util.List;

public class QueryInstanceResponse extends Response {

  private List<ServiceInstance> instances;

  public QueryInstanceResponse() {
  }

  public QueryInstanceResponse(List<ServiceInstance> instances) {
    this.instances = instances;
    this.responseCode = SUCCESS_CODE;
  }

  public List<ServiceInstance> getInstances() {
    return instances;
  }

  public void setInstances(List<ServiceInstance> instances) {
    this.instances = instances;
  }
}
