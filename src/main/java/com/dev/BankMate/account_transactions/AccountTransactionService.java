package com.dev.BankMate.account_transactions;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountTransactionService {
    private AccountTransactionRepository repository;

    public List<AccountTransaction> getBalanceDetails(int id ){
        return repository.findAccountTransactionsByUserIdOrderByTransactionDateDesc(id);
    }
}
