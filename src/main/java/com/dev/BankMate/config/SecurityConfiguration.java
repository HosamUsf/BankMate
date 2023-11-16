package com.dev.BankMate.config;

import com.dev.BankMate.filter.AuthoriteisLoginAfterFilter;
import com.dev.BankMate.filter.AuthoritiesLoggingAtFilter;
import com.dev.BankMate.filter.CsrfCookieFilter;
import com.dev.BankMate.filter.RequestValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // CSRF Token Request Attribute Handler
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        return http
                // Security Context Configuration
                .securityContext(context -> context.requireExplicitSave(false))

                // Session Management Configuration
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))

                // CORS Configuration
                .cors(withDefaults())  // by default uses a Bean by the name of corsConfigurationSource

                // CSRF Configuration
                .csrf(csrf -> csrf
                        .csrfTokenRequestHandler(requestHandler)
                        .ignoringRequestMatchers("/contact", "/register")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                )

                // CSRF Filter
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)

                // Custom Filter to prevent the user with "test" from logging in
                .addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)

                // Custom Filter to log the user info
                .addFilterAfter(new AuthoriteisLoginAfterFilter(), BasicAuthenticationFilter.class)

                // Custom Filter to log the Authentication progress
                .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)

                // Authorization Rules
                .authorizeHttpRequests(requests -> {
                    // Admin Role for specific paths
                    requests.requestMatchers(
                            new AntPathRequestMatcher("/myAccount"),
                            new AntPathRequestMatcher("/myLoans"),
                            new AntPathRequestMatcher("/myCards"),
                            new AntPathRequestMatcher("/user"),
                            new AntPathRequestMatcher("/myBalance")).hasRole("ADMIN");

                    // User Role for "/user" path
                    requests.requestMatchers(new AntPathRequestMatcher("/user")).hasRole("USER");

                    // Permit all for specific paths
                    requests.requestMatchers(
                            new AntPathRequestMatcher("/contact"),
                            new AntPathRequestMatcher("/notices"),
                            new AntPathRequestMatcher("/**"),
                            new AntPathRequestMatcher("/register")).permitAll();
                })

                // Form and Basic Authentication Configuration
                .formLogin(withDefaults())
                .httpBasic(withDefaults())

                .build();
    }

    // Configure CORS (Cross-Origin Resource Sharing)
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Collections.singletonList("*"));

        // Create a URL-based CORS configuration source for all paths
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;


    }


    // Configure Password Encoder for secure password storage
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
