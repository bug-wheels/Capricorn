package com.github.bw.capricorn.example;

import com.github.bw.capricorn.server.EnableCapricornServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCapricornServer
public class CapricornServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(CapricornServerApplication.class, args);
  }
}
