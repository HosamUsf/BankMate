package com.dev.BankMate.registration;

import com.dev.BankMate.exceptions.EmailAlreadyExistException;
import com.dev.BankMate.request.RegistrationRequest;
import com.dev.BankMate.user.User;
import com.dev.BankMate.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public String register(RegistrationRequest request) {

        Optional<User> user = this.userRepository.findUserByEmail(request.email());
        if (user.isPresent()) {
            throw new EmailAlreadyExistException("User with username " + request.email() + " already exist");
        }
        String encodedPassword = passwordEncoder.encode(request.password());
        User newUser = new User(request.username(), request.email(),encodedPassword , request.role());
        userRepository.save(newUser);
        System.out.println(encodedPassword);
        System.out.println(request.password());
        return "Registration Successfully completed";
    }
}
