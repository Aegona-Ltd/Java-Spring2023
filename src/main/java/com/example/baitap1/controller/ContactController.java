package com.example.baitap1.controller;

import com.example.baitap1.entity.Contact;
import com.example.baitap1.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;

    @PostMapping("/saveContact")
    public Contact addContact(@RequestBody Contact contact){

        return contactService.createContact(contact);
    }


}
