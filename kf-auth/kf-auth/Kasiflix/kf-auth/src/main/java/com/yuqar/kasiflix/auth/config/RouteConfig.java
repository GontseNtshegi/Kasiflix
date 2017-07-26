package com.yuqar.kasiflix.auth.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Gntshegi on 2017/07/26.
 */
@Configuration
public class RouteConfig {
  public static final String BASE = "kasiflix/api/v1";

  // AuthenticationController
  public static final String AUTHENT_BASE = BASE + "/auth";

  private RouteConfig() {
    throw new UnsupportedOperationException();
  }
}
