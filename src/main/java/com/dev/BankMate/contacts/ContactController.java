package com.dev.BankMate.contacts;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ContactController {
    private ContactService service;

    @PostFilter("filterObject.contactName != 'Test'")
    @PostMapping("/contact")
    public List<Contact> saveContactInquiryDetails(@RequestBody List<Contact> contacts) {
        return service.saveContactDetails(contacts);
    }
}
