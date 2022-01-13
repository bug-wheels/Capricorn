package com.github.bw.capricorn.server.config;

import com.github.bw.capricorn.server.endpoint.JdbcServerServiceRegistry;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@AutoConfigureAfter(com.github.bw.capricorn.server.config.DataSourceTransactionManagerAutoConfiguration.class)
public class ServerServiceRegistryAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public JdbcServerServiceRegistry jdbcServerServiceRegistry(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    return new JdbcServerServiceRegistry(namedParameterJdbcTemplate);
  }
}
