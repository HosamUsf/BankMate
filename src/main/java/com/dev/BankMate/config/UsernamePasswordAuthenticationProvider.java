package com.dev.BankMate.config;

import com.dev.BankMate.user.AppUser;
import com.dev.BankMate.user.UserRepository;
import com.dev.BankMate.user.authorites.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        AppUser appUser = userRepository.findUserByEmail(username)
                .orElseThrow(() -> new BadCredentialsException("Sorry, either your email or password is incorrect."));

        if (passwordEncoder.matches(password, appUser.getPassword())) {

            return new UsernamePasswordAuthenticationToken(username, password, getGrantedAuthority(appUser.getAuthorities()));
        } else {
            throw new BadCredentialsException("Sorry, either your email or password is incorrect.");
        }

    }

    private List<GrantedAuthority> getGrantedAuthority(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));


    }
}
