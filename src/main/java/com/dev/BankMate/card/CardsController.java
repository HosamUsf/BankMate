package com.dev.BankMate.card;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CardsController {
    private CardService service;

    @GetMapping("/myCards")
    public List<Card> getCardDetails(@RequestParam int id) {
        return service.getCardDetails(id);
    }
}
