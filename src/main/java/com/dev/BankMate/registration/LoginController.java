package com.dev.BankMate.registration;

import com.dev.BankMate.user.AppUser;
import com.dev.BankMate.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@AllArgsConstructor
public class LoginController {
    private UserRepository repository ;

    @RequestMapping("/user")
    public AppUser getUserDetailsAfterLogin(Authentication authentication){
        return repository.findUserByEmail(authentication.getName()).orElse(null);
    }
}
