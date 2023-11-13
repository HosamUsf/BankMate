//package com.dev.BankMate.user;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.Collections;
//
//
//
//@Service
//@AllArgsConstructor
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private UserRepository userRepository ;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return this.userRepository.findUserByEmail(username)
//                .map(UserAdapter::new)
//                .orElseThrow(() -> new UsernameNotFoundException("Email or Password are Wrong!"));
//    }
//
//
//
//    private static class UserAdapter extends User implements UserDetails {
//        private UserAdapter(User user){
//            super(user);
//        }
//
//        @Override
//        public Collection<? extends GrantedAuthority> getAuthorities() {
//            SimpleGrantedAuthority  authority =
//                    new SimpleGrantedAuthority(getUserRole());
//            return Collections.singletonList(authority);
//        }
//
//        @Override
//        public String getUsername() {
//            return getEmail();
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//            return true;
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isEnabled() {
//            return true;
//        }
//    }
//}
