package com.dev.BankMate.loans;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoanService {
    private LoanRepository repository;

    @PreAuthorize("hasRole('USER')")
    public List<Loan> getLoanDetails(int id ){
        return repository.findAllByUserIdOrderByStartDateDesc(id);
    }

}
