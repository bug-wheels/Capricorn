package com.github.bw.capricorn.commons.response;

import com.github.bw.capricorn.commons.DefaultServiceInstance;
import java.util.List;

public class QueryInstanceResponse extends Response {

  private List<DefaultServiceInstance> instances;

  public QueryInstanceResponse() {
  }

  public QueryInstanceResponse(List<DefaultServiceInstance> instances) {
    this.instances = instances;
    this.responseCode = SUCCESS_CODE;
  }

  public List<DefaultServiceInstance> getInstances() {
    return instances;
  }

  public void setInstances(List<DefaultServiceInstance> instances) {
    this.instances = instances;
  }
}
