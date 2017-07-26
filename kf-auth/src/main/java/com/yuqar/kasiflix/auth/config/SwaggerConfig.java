package com.yuqar.kasiflix.auth.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by Gntshegi on 2017/07/26.
 */
public class SwaggerConfig {
  @Bean
  public Docket authentApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("auth-api").apiInfo(apiInfo()).select()
        .paths(authentPaths()).build();
  }

  private Predicate<String> authentPaths() {
    return regex(RouteConfig.AUTHENT_BASE + ".*");
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Kasi-flix Auth API").description("Services dealing with Authentication.").build();
  }
}
