package com.dev.BankMate.contacts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class ContactService {
    private ContactRepository repository;

    public Contact saveContactDetails(Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateAt(LocalDateTime.now());
        return repository.save(contact);
    }

    private String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999 ;
        return "SR"+ranNum;
    }
}
