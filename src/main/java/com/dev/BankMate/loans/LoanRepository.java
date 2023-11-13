package com.dev.BankMate.loans;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan,Integer> {

    List<Loan> findAllByUserIdOrderByStartDateDesc(int userId);
}
