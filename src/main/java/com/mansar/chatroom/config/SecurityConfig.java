package com.mansar.chatroom.config;

import com.mansar.chatroom.security.AuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private static final String [] ALLOWED_PATHS = {"/Login"};

    public SecurityConfig(@Lazy AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    public SecurityFilterChain httpSecurity(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authenticationProvider(authenticationProvider)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .authorizeHttpRequests(request -> request.requestMatchers(ALLOWED_PATHS)
                        .permitAll()
                        .anyRequest().authenticated()
                );

        return httpSecurity.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
