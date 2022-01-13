package com.github.bw.capricorn.server.endpoint;

public class RegisterResult {

  private String instanceId;

  public RegisterResult() {
  }

  public RegisterResult(String instanceId) {
    this.instanceId = instanceId;
  }

  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }
}
