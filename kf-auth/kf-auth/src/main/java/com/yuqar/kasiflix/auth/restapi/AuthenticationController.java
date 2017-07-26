package com.yuqar.kasiflix.auth.restapi;

import com.yuqar.kasiflix.auth.config.RouteConfig;
import com.yuqar.kasiflix.auth.dto.AuthRequest;
import com.yuqar.kasiflix.auth.dto.AuthResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * Created by Gntshegi on 2017/07/26.
 */
@RestController
public class AuthenticationController {
  @RequestMapping(value = RouteConfig.AUTHENT_BASE,method= RequestMethod.GET)
  public void login(@Valid @RequestBody AuthRequest request) {
    return ;//loginProcessor.login(request.getUsername(), request.getPassword())
        //.map(t -> new LoginResponse(Optional.of(t))).orElseThrow(() -> new UnauthorizedException());
  }
}
