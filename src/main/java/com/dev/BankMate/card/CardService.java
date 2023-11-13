package com.dev.BankMate.card;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CardService {
    private CardRepository repository ;

    public List<Card> getCardDetails(int id ){
        return repository.findAllByUserId(id);
    }
}
