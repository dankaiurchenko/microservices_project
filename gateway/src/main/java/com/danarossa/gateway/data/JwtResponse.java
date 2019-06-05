package com.danarossa.gateway.data;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private Integer userId;
    private Collection<? extends GrantedAuthority> authorities;


    public JwtResponse(String token, String username, Integer userId, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.username = username;
        this.userId = userId;
        this.authorities = authorities;
    }
}