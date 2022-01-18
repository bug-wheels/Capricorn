package com.github.bw.capricorn.server.config;

import com.github.bw.capricorn.server.endpoint.MyBatisServerServiceRegistry;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(com.github.bw.capricorn.server.config.DataSourceTransactionManagerAutoConfiguration.class)
public class ServerServiceRegistryAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public MyBatisServerServiceRegistry jdbcServerServiceRegistry(DataSource dataSource) {
    return new MyBatisServerServiceRegistry(dataSource);
  }
}
