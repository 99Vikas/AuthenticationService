package com.railway.authservice.Controller;

import com.railway.authservice.Model.AuthenticationRequest;
import com.railway.authservice.Model.AuthenticationResponse;
import com.railway.authservice.Security.UserDetailService;
import com.railway.authservice.Service.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserDetailService userDetailService;

    @PostMapping()
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println("controller");
        UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword(),  userDetails.getAuthorities()));
        final String jwt = jwtUtil.generateToken(userDetails, authentication.getAuthorities());
        return ResponseEntity.ok(new AuthenticationResponse(jwt, jwtUtil.extractExpiration(jwt)));
    }


}