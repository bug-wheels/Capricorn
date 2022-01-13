package com.github.bw.capricorn.commons;

import java.util.Map;

public interface ServiceInstance {

  default String getInstanceId() {
    return null;
  }

  String getServiceId();

  String getHost();

  int getPort();

  Map<String, String> getMetadata();

}
