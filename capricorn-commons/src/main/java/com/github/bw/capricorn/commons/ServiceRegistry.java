package com.github.bw.capricorn.commons;

public interface ServiceRegistry<R extends Registration> {

  void register(R registration);

  void deregister(R registration);

  void setStatus(R registration, String status);

  <T> T getStatus(R registration);

}
