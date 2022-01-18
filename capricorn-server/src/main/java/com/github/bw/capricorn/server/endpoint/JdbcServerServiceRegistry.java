package com.github.bw.capricorn.server.endpoint;

import com.github.bw.capricorn.commons.Registration;
import com.github.bw.capricorn.commons.ServiceInstance;
import com.github.bw.capricorn.commons.response.InstanceHealthStatus;
import java.util.List;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class JdbcServerServiceRegistry implements DiscoveryRegistry<Registration> {

  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public JdbcServerServiceRegistry(
      NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  @Override
  public void register(Registration registration) {

  }

  @Override
  public void deregister(Registration registration) {

  }

  @Override
  public void setStatus(Registration registration, String status) {

  }

  @Override
  public <T> T getStatus(Registration registration) {
    return null;
  }

  @Override
  public List<ServiceInstance> instances(String dc, String ns, String serviceId,
      InstanceHealthStatus instanceHealthStatus) {
    return null;
  }
}
