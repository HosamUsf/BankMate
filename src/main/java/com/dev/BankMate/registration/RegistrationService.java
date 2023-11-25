package com.dev.BankMate.registration;

import com.dev.BankMate.exceptions.EmailAlreadyExistException;
import com.dev.BankMate.request.RegistrationRequest;
import com.dev.BankMate.user.AppUser;
import com.dev.BankMate.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public String register(RegistrationRequest request) {
        Optional<AppUser> user = this.userRepository.findUserByEmail(request.email());
        if (user.isPresent()) {
            throw new EmailAlreadyExistException("User with email " + request.email() + " already exist");
        }
        String encodedPassword = passwordEncoder.encode(request.password());
        AppUser newAppUser = new AppUser(request.username(), request.email(),encodedPassword ,request.mobileNumber(), request.role());
        newAppUser.setCreatedAt(LocalDateTime.now());
        userRepository.save(newAppUser);
        return "Given user details are successfully registerd";
    }
}
