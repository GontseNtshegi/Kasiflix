package com.yuqar.kasiflix.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by Gntshegi on 2017/07/26.
 */
@SpringBootApplication
public class AuthenticationMain extends SpringBootServletInitializer {
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(AuthenticationMain.class);
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(AuthenticationMain.class, args);
  }
}