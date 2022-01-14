package com.github.bw.capricorn.serviceregistry;

import java.net.URI;
import java.util.Map;
import org.springframework.cloud.client.serviceregistry.Registration;

public class CapricornRegistration implements Registration {

  @Override
  public String getInstanceId() {
    return Registration.super.getInstanceId();
  }

  @Override
  public String getServiceId() {
    return null;
  }

  @Override
  public String getHost() {
    return null;
  }

  @Override
  public int getPort() {
    return 0;
  }

  @Override
  public boolean isSecure() {
    return false;
  }

  @Override
  public URI getUri() {
    return null;
  }

  @Override
  public Map<String, String> getMetadata() {
    return null;
  }

  @Override
  public String getScheme() {
    return Registration.super.getScheme();
  }
}
