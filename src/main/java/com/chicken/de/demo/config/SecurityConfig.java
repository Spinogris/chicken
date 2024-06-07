package com.chicken.de.demo.config;

import com.chicken.de.demo.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private final JwtAuthenticationFilter authenticationFilter;

    private static final String[] SWAGGER = {
            "/v2/api-docs",
            "/v3/api-docs/",
            "/swagger-resources/",
            "/swagger-resources",
            "/swagger-ui/",
            "/swagger-ui.html",
            "/swagger-ui/",
            "/webjars/",
            "/configuration/",
            "/configuration/ui",
            "/swagger-ui/**", "/v3/api-docs/**",
            "/configuration/security",
            "/public",
            "/favicon.ico",
            "/h2-console/",
            "/conferenc/v1/swagger-ui.html",
            "/swagger-resources/configuration/ui",
            "/swagger-resources/configuration/security",
            "/",
            "/login", "/logout",
            "/csrf"
    };

    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return NoOpPasswordEncoder.getInstance(); // Не зашифрованный
        return new BCryptPasswordEncoder(); // Зашифрованный
    }

    @Bean
    public AuthenticationManager authenticationManager(PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(daoAuthenticationProvider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
//                .csrf(csrf -> csrf
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(SWAGGER).permitAll()
                        .requestMatchers("/chicken/accounts/login").permitAll()
                        .anyRequest().permitAll()) //authenticated())
                .httpBasic(Customizer.withDefaults())
                .logout(Customizer.withDefaults())
                .authenticationManager(authenticationManager)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}