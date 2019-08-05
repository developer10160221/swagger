package com.example.swagger;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api")
public class AddressBookResource {
    ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    public Contact getContact(@PathVariable String id) {
        return contacts.get(id);
    }

    @GetMapping("/")
    public ArrayList<Contact> getAllContacts() {
        return new ArrayList<Contact>(contacts.values());
    }

    @PostMapping("/")
    public Contact addContent(@RequestBody Contact contact) {
        contacts.put(contact.getId(), contact);
        return contact;
    }
}
