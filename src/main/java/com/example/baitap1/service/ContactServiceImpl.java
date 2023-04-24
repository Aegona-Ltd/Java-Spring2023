package com.example.baitap1.service;

import com.example.baitap1.entity.Contact;
import com.example.baitap1.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepo;

    @Override
    public Contact createContact(Contact contact) {

        return contactRepo.save(contact);
    }


}
