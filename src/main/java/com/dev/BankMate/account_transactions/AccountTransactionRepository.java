package com.dev.BankMate.account_transactions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Integer> {

    List<AccountTransaction> findAccountTransactionsByUserIdOrderByTransactionDateDesc(int userId);
}
