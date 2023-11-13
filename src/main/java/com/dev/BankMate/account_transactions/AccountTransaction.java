package com.dev.BankMate.account_transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_transactions")
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;

    @NotEmpty
    private int accountNumber ;

    @NotEmpty
    @JsonProperty("customerId")
    private int userId ;

    @NotEmpty
    @JsonProperty("transactionDt")
    private LocalDateTime transactionDate;

    @NotEmpty
    private String transactionSummary;

    @NotEmpty
    private String transactionType;

    @NotEmpty
    @JsonProperty("transactionAmt")
    private double transactionAmount;

    @NotEmpty
    private double closingBalance;

    @NotEmpty
    @JsonProperty("createDt")
    private LocalDateTime createAt;




}
