package com.yuqar.kasiflix.auth.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import com.google.common.base.Throwables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.springframework.stereotype.Service;

import com.yuqar.kasiflix.auth.config.AuthConfig;

import java.util.Calendar;
//import java.util.stream.Collectors;

@Service
public class JwtTokenGenerator {

	private @Autowired AuthConfig authConfig;
  private @Autowired
	Signer signer;

	private ObjectWriter jsonWriter = new ObjectMapper().writer();

	public String generate(User user) {
		Jwt jwt;
		try {
			Calendar expires = Calendar.getInstance();
			expires.add(Calendar.MINUTE, authConfig.getTokenExpiryInMinutes());
			TokenContent content = new TokenContent(user.getUsername(),expires.getTime());
					//user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()),
					//expires.getTime());
			jwt = JwtHelper.encode(jsonWriter.writeValueAsString(content), signer);
		} catch (Exception e) {
			throw Throwables.propagate(e);
		}
		return jwt.getEncoded();
	}

}