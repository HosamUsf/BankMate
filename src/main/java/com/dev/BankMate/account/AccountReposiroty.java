package com.dev.BankMate.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountReposiroty extends JpaRepository<Account,Integer> {

    Optional<Account> findAccountByUserId(int userId);
}
