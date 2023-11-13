package com.dev.BankMate.account_transactions;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;

    @NotEmpty
    private int accountNumber ;

    @NotEmpty
    private int userId ;

    @NotEmpty
    private LocalDateTime transactionDate;

    @NotEmpty
    private String transactionSummary;

    @NotEmpty
    private String transactionType;

    @NotEmpty
    private double transactionAmount;

    @NotEmpty
    private double closingBalance;

    @NotEmpty
    private LocalDateTime createAt;




}
