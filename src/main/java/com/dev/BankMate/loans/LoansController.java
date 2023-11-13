package com.dev.BankMate.loans;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class LoansController {
    private LoanService service;

    @GetMapping("/myLoans")
    public List<Loan> getLoanDetails(@RequestParam int id) {
        return service.getLoanDetails(id) ;
    }
}
