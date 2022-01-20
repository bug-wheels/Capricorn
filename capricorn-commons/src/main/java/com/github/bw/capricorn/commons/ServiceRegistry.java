package com.github.bw.capricorn.commons;

import com.github.bw.capricorn.commons.response.InstanceHealthStatus;

public interface ServiceRegistry<R extends Registration> {

  void register(R registration);

  void deregister(R registration);

  void setStatus(R registration, InstanceHealthStatus status);

  <T> T getStatus(R registration);

}
