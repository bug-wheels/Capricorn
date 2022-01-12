package com.github.bw.capricorn.server.config;

import com.github.bw.capricorn.server.endpoint.RegisterEndPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
public class EndPointAutoConfig {

  @Bean
  @ConditionalOnMissingBean
  public RegisterEndPoint registerEndPoint() {
    return new RegisterEndPoint();
  }
}
