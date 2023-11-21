package com.dev.BankMate.filter;

import com.dev.BankMate.constants.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class JWTTokenValidatorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        // Retrieve the JWT token from the request header
        String jwt = request.getHeader(SecurityConstants.JWT_HEADER);

        // Check if the JWT token is present
        if (jwt != null) {
            try {
                // Generate a secret key for validating the JWT
                SecretKey secretKey = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));

                // Parse and validate the JWT token
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(secretKey)
                        .build()
                        .parseClaimsJws(jwt)
                        .getBody();

                // Extract information from the JWT claims
                String username = String.valueOf(claims.get("username"));
                String authorities = (String) claims.get("authorities");

                // Create an authentication object and set it in the security context
                Authentication auth = new UsernamePasswordAuthenticationToken(
                        username, null, AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));

                SecurityContextHolder.getContext().setAuthentication(auth);

            } catch (Exception e) {
                // Throw a BadCredentialsException if the token is invalid
                throw new BadCredentialsException("Invalid Token received!");
            }
        }

        // Continue with the filter chain
        filterChain.doFilter(request, response);
    }

    // This method determines whether the filter should be applied  on login request.
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return (request.getServletPath().equals("/user") || request.getServletPath().equals("/contact"));
    }
}

