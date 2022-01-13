package com.github.bw.capricorn.commons.response;

public class InstanceRegisterResponse extends Response {

  private String instanceId;

  public InstanceRegisterResponse() {
  }

  public InstanceRegisterResponse(String instanceId) {
    this.instanceId = instanceId;
    this.responseCode = SUCCESS_CODE;
  }

  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }
}
