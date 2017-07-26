package com.yuqar.kasiflix.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;

/**
 * Created by Gntshegi on 2017/07/26.
 */
@Component
@Data
@ConfigurationProperties("kasiflix.auth")
public class AuthConfig {
  @Min(0)
  private int tokenExpiryInMinutes;
}
