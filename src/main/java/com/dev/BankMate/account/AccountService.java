package com.dev.BankMate.account;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {
AccountReposiroty reposiroty ;

    public Account getAccountDetails (int id ){
        return reposiroty.findAccountByUserId(id).orElseThrow(null);
    }
}
