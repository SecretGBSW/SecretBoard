package com.example.anonymousboard.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http
      .csrf(AbstractHttpConfigurer::disable)
      .cors(AbstractHttpConfigurer::disable)
      .headers((headerConfig) ->
        headerConfig.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable
        )
      )
      .authorizeHttpRequests((authorize) ->
        authorize

          .requestMatchers(
            "/**"
          ).permitAll()

          .requestMatchers(HttpMethod.GET).permitAll()
          .requestMatchers(HttpMethod.POST).permitAll()
          .requestMatchers(HttpMethod.PUT).permitAll()
          .requestMatchers(HttpMethod.DELETE).permitAll()

          .anyRequest().authenticated()
      );
    return http.getOrBuild();
  }
}
