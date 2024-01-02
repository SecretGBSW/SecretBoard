package com.example.anonymousboard.board.config;

import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class boardConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000", "*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setExposedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
          .csrf(AbstractHttpConfigurer::disable)
          .cors((cors) -> {
              cors.configurationSource(corsConfigurationSource());
          })
          .headers((headerConfig) ->
            headerConfig.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)
          )
          .authorizeHttpRequests((authorize) ->
            authorize
              .requestMatchers(
                "/**"
              ).permitAll()
              .requestMatchers(HttpMethod.GET, "/**").permitAll()
              .requestMatchers(HttpMethod.POST, "/**").permitAll()
              .requestMatchers(HttpMethod.PUT, "/**").permitAll()
              .requestMatchers(HttpMethod.DELETE, "/**").permitAll()
              .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

              .anyRequest().permitAll()
          );
        return http.build();
    }
}
