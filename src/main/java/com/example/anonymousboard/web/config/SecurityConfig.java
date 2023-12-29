package com.example.anonymousboard.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer{
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
      .addMapping("/**")
      .allowedOrigins("*")
      .allowedMethods(
        HttpMethod.GET.name(),
        HttpMethod.HEAD.name(),
        HttpMethod.POST.name(),
        HttpMethod.PUT.name(),
        HttpMethod.DELETE.name()
      );
  }
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
