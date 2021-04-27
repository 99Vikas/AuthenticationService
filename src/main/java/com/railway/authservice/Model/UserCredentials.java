package com.railway.authservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCredentials {
    private String username, password;
    private List<GrantedAuthority> roles;
}