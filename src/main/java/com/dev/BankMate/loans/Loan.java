package com.dev.BankMate.loans;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanNumber;

    @NotEmpty
    private int userId ;

    @NotEmpty
    private LocalDateTime startDate;

    @NotEmpty
    private double totalLoan;

  @NotEmpty
    private double amountPaid;

    @NotEmpty
    private double outstandingAmount;

    @NotEmpty
    private LocalDateTime createAt;




}
