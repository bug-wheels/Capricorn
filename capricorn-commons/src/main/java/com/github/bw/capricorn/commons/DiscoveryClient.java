package com.github.bw.capricorn.commons;

import java.util.List;

/**
 * 发现 Client
 */
public interface DiscoveryClient {

  /**
   * 根据 serviceId 查询出所有的实例
   * @param serviceId 服务 id
   */
  List<ServiceInstance> getInstances(String serviceId);

  /**
   * 查询所有的服务名
   */
  List<String> getServices();
}
