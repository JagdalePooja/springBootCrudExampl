package com.example.curdDemo.service;

import com.example.curdDemo.model.Contact;
import com.example.curdDemo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }
    public Optional<Contact> findById(int id) {
        return contactRepository.findById(id);
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(int id, Contact contact) {
        Contact updatedContact = contactRepository.findById(id).orElse(null);
        updatedContact.setName(contact.getName());
        updatedContact.setEmail(contact.getEmail());
        updatedContact.setCountry(contact.getCountry());
        return contactRepository.save(updatedContact);
    }

    public void deleteById(int id) {
        contactRepository.deleteById(id);
    }

}
