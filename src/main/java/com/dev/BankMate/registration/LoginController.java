package com.dev.BankMate.registration;

import com.dev.BankMate.user.AppUser;
import com.dev.BankMate.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class LoginController {
    private UserRepository repository ;

    @RequestMapping("/user")
    public AppUser getUserDetailsAfterLogin(Authentication authentication){
        AppUser user = repository.findUserByEmail(authentication.getName()).orElse(null);
        return user;
    }
}
