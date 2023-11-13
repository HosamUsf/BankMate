package com.dev.BankMate.registration;

import com.dev.BankMate.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegistrationController {
    private RegistrationService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody RegistrationRequest request){
        return new ResponseEntity<>(service.register(request), HttpStatus.CREATED);
    }
}
