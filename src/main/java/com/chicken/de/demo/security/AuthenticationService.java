package com.chicken.de.demo.security;

import com.chicken.de.demo.security.model.JwtAuthenticationResponse;
import com.chicken.de.demo.security.model.SignInRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse authenticate(SignInRequest request);
}
