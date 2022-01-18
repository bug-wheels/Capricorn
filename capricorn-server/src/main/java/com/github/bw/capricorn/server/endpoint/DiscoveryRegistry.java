package com.github.bw.capricorn.server.endpoint;

import com.github.bw.capricorn.commons.Registration;
import com.github.bw.capricorn.commons.ServiceInstance;
import com.github.bw.capricorn.commons.ServiceRegistry;
import com.github.bw.capricorn.commons.response.InstanceHealthStatus;
import java.util.List;

public interface DiscoveryRegistry<R extends Registration> extends ServiceRegistry<R> {

  List<ServiceInstance> instances(String dc, String ns, String serviceId, InstanceHealthStatus instanceHealthStatus);

}
