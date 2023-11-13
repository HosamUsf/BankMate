package com.dev.BankMate.account;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class AccountController {
    private AccountService service;

    @GetMapping("/myAccount")
    public Account getAccountDetails(@RequestParam int id) {
        return service.getAccountDetails(id);
    }

}
