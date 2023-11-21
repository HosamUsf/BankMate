package com.dev.BankMate.contacts;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class ContactService {
    private ContactRepository repository;

    @PreFilter("filterObject.contactName != 'Test'")
    public List<Contact> saveContactDetails(List<Contact> contacts) {
        Contact contact = contacts.get(0);
        contact.setContactId(getServiceReqNumber());
        contact.setCreateAt(LocalDateTime.now());
        repository.save(contact);
        List<Contact> returnContacts = new ArrayList<>();
        returnContacts.add(contact);
        return returnContacts;
    }

    private String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999 ;
        return "SR"+ranNum;
    }
}
