package org.humber.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Profile("dev")
    public SecurityFilterChain securityFilterChainForDev(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .anyRequest().permitAll()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/swagger-ui.html")
                )
                .logout(logout -> logout
                        .permitAll()
                        .logoutSuccessUrl("/")
                )
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedPage("/access-denied.html")
                )
                .build();
    }


    @Bean
    @Profile("prod")
    public SecurityFilterChain securityFilterChainForProd(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .anyRequest().permitAll()
                        /* .requestMatchers(HttpMethod.GET, "/api/students/**").hasRole("STUDENT")
                        .requestMatchers("/api/students/**").hasRole("STUDENT")
                        .requestMatchers("/api/**").hasRole("ADMIN")
                        .requestMatchers("/user", "/user/**").permitAll() // For user registration API
                        .requestMatchers("/", "/index*", "/login", "/register*").permitAll() // For user registration UI
                        .requestMatchers("/style/*", "/script/*").permitAll() // For static resources
                        .anyRequest().authenticated() */
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/swagger-ui.html")
                )
                .logout(logout -> logout
                        .permitAll()
                        .logoutSuccessUrl("/")
                )
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedPage("/access-denied.html")
                )
                .build();
    }
}
