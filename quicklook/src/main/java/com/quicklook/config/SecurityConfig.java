package com.quicklook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())     // Desactiva CSRF
            .cors(cors -> cors.disable())     // Desactiva CORS (solo para pruebas)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()  // Permitir login/registro
                .anyRequest().authenticated()
            );

        return http.build();
    }
}
