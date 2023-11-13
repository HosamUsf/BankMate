package com.dev.BankMate.card;

import jakarta.persistence.Entity;
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
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId ;

    @NotEmpty
    private String cardNumber;

    @NotEmpty
    private int userId;

    @NotEmpty
    private String cardType;

    @NotEmpty
    private double totalLimit;

    @NotEmpty
    private double amountUsed;
    @NotEmpty
    private double availableAmount;

    @NotEmpty
    private LocalDateTime createdAt;

}
