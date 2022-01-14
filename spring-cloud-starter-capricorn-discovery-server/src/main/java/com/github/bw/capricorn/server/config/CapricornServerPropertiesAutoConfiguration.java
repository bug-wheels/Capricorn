package com.github.bw.capricorn.server.config;

import com.github.bw.capricorn.server.util.Files;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CapricornServerPropertiesAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public CapricornServerProperties capricornServerProperties() {
    return new CapricornServerProperties();
  }

  @Bean
  @ConditionalOnProperty(value = "capricorn.banner", matchIfMissing = true)
  public Banner capricornServerBeanBanner() {

    Banner banner = new Banner();
    try {
      banner.echo();
    } catch (Exception e) {
      // pass
    }
    return banner;
  }

  class Banner {

    void echo() throws IOException {
      String bannerPath = getClass().getResource("/capricorn-banner.txt").getFile();
      String bannerText = Files.readAsString(bannerPath, StandardCharsets.UTF_8);
      System.out.println(bannerText);
    }
  }
}
