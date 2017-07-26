package com.yuqar.kasiflix.auth.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * Created by Gntshegi on 2017/07/26.
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception{
    http
        //Disable CSRF tokens
       .csrf().disable()
        //Allow all calls
       .authorizeRequests().anyRequest().permitAll()
        //stateless sessions
    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }
  @Bean
  public WebMvcConfigurer corsConfigurer(){
    return new WebMvcConfigurerAdapter() {

      @Override
      public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/kasiflix/api/**");
      }
    };
  }
}
