package com.dev.BankMate.config;

import com.dev.BankMate.user.User;
import com.dev.BankMate.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {
    private PasswordEncoder passwordEncoder ;
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String  password = authentication.getCredentials().toString();

        User user = userRepository.findUserByEmail(username)
                .orElseThrow(() -> new BadCredentialsException("Sorry, either your email or password is incorrect."));

        if(passwordEncoder.matches(password,user.getPassword())){
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getUserRole()));
            return new UsernamePasswordAuthenticationToken(username,password,authorities);
        } else {
            throw new BadCredentialsException("Sorry, either your email or password is incorrect.");
        }




    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));


    }
}
