package com.intercert.verifycertificate.shared.infrastructure.security.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs
                .authorizeHttpRequests((authz) -> authz
                        // Allow public access to everything under /api/v1/certificate
                        .requestMatchers("/api/v1/certificate/**").permitAll()
                        // Allow public access to Swagger endpoints
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        // Deny all other requests
                        .anyRequest().denyAll()
                ); // Enable HTTP Basic authentication (not required for public endpoints)

        return http.build();
    }
}
