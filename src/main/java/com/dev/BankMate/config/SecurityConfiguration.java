package com.dev.BankMate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf
                        .ignoringRequestMatchers(toH2Console()).disable()).
                authorizeHttpRequests(requests -> {
                            requests.requestMatchers(new AntPathRequestMatcher("/myAccount"),
                                    new AntPathRequestMatcher("/myLoans"),
                                    new AntPathRequestMatcher("/myCards"),
                                    new AntPathRequestMatcher("/myBalance")).authenticated();

                            requests.requestMatchers(new AntPathRequestMatcher("/contact"),
                                    new AntPathRequestMatcher("/notices"),
                                    new AntPathRequestMatcher("/register")).permitAll();
                        }
                ).formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
//
//    @Bean
//    public InMemoryUserDetailsManager UserDetailsService(){
//        UserDetails admin = User.withUsername("hosam")
//                .password("123456")
//                .authorities("admin")
//                .build();
//
//        UserDetails user = User.withUsername("omar")
//                .password("123456")
//                .authorities("admin")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//
//    }


//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
