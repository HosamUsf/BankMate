package com.dev.BankMate.loans;

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
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanNumber;

    @NotEmpty
    @JsonProperty("customerId")
    private int userId ;

    @NotEmpty
    @JsonProperty("startDt")
    private LocalDateTime startDate;

    @NotEmpty
    private double totalLoan;

  @NotEmpty
    private double amountPaid;

    @Column(name = "loan_type")
    @JsonProperty("loanType")
    private String loanType;
    @NotEmpty
    private double outstandingAmount;

    @NotEmpty
    @JsonProperty("createDt")
    private LocalDateTime createAt;




}
