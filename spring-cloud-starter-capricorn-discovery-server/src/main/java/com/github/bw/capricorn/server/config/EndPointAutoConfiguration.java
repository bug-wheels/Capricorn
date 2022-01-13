package com.github.bw.capricorn.server.config;

import com.github.bw.capricorn.server.endpoint.JdbcServerServiceRegistry;
import com.github.bw.capricorn.server.endpoint.RegisterEndPoint;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
@AutoConfigureAfter(com.github.bw.capricorn.server.config.ServerServiceRegistryAutoConfiguration.class)
public class EndPointAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public RegisterEndPoint registerEndPoint(JdbcServerServiceRegistry jdbcServerServiceRegistry) {
    return new RegisterEndPoint(jdbcServerServiceRegistry);
  }
}
