package com.dev.BankMate.account_transactions;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BalanceController {
    private AccountTransactionService service;

    @GetMapping("/myBalance")
    public List<AccountTransaction> getBalanceDetails(@RequestParam int id) {
        return service.getBalanceDetails(id);
    }
}
