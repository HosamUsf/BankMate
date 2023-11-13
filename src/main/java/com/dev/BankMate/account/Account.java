package com.dev.BankMate.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNumber ;

    @Column(name = "user_id")

    private int userId;

    @NotEmpty
    private String accountType ;

    @NotEmpty
    private String branchAddress;

    @NotEmpty
    @JsonProperty("createDt")
    private LocalDateTime createDate;



}
