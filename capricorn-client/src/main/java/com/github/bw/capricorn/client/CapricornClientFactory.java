package com.github.bw.capricorn.client;

import com.github.bw.capricorn.client.util.ClientGenerator;
import java.util.Objects;

public class CapricornClientFactory {

  public static CapricornClient newInstance(String baseUrl) {
    return newInstance(baseUrl, false);
  }

  public static CapricornClient newInstance(String baseUrl, boolean withLogger) {
    Objects.requireNonNull(baseUrl, "baseUrl is non null");
    CapricornApiClient capricornApiClient = ClientGenerator
        .createService(CapricornApiClient.class, baseUrl, withLogger);
    return new CapricornClient(capricornApiClient);
  }
}
