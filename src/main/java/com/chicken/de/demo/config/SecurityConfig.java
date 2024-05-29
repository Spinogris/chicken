package com.chicken.de.demo.config;

import com.chicken.de.demo.DTO.StandardResponseDto;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.converter.ResolvedSchema;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.chicken.de.demo.documentation.OpenApiDocumentation.*;
import static com.chicken.de.demo.documentation.OpenApiDocumentation.buildAuthenticationPath;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(prePostEnabled = true) //todo прочитать что это?
@EnableMethodSecurity
public class SecurityConfig {

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
        return NoOpPasswordEncoder.getInstance(); // Не зашифрованный
        //return new BCryptPasswordEncoder(); // Зашифрованный
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
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))        // Устанавливает репозиторий для хранения CSRF токенов в cookie. withHttpOnlyFalse() указывает, что cookie не будет иметь флаг HttpOnly, что позволяет JavaScript на клиенте получить доступ к этому cookie (не рекомендуется в большинстве случаев для безопасности).
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(SWAGGER).permitAll()// Включает настройку авторизации запросов.
                        .requestMatchers("/chicken/accounts/login").permitAll()
                        .anyRequest().permitAll()) //authenticated())      // Все остальные запросы требуют аутентификации.
                .httpBasic(Customizer.withDefaults())       // Включает HTTP Basic аутентификацию с настройками по умолчанию. Это простая форма аутентификации, которая передаёт имя пользователя и пароль в заголовке HTTP запроса.
                .logout(Customizer.withDefaults())      // Пользователь будет разлогинен
                .authenticationManager(authenticationManager)       // Устанавливает кастомный AuthenticationManager для обработки аутентификации.
                .build();       // Метод build() завершает конфигурацию и создаёт объект SecurityFilterChain, который будет применён ко всем запросам.
    }
}