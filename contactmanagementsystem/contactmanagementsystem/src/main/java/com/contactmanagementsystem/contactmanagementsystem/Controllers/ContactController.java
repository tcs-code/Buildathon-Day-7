package com.contactmanagementsystem.contactmanagementsystem.Controllers;

import com.contactmanagementsystem.contactmanagementsystem.Models.Contacts;
import com.contactmanagementsystem.contactmanagementsystem.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/addUser")
    public ResponseEntity<Map<String, String>> addUser(@RequestBody Contacts contact) {
        contactRepository.save(contact);
        Map<String, String> response = new HashMap<>();
        response.put("Status", "Success");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/viewAllUsers")
    public ResponseEntity<List<Contacts>> viewAllUsers() {
        List<Contacts> contactList = contactRepository.viewAllUsers();
        return ResponseEntity.ok(contactList);
    }

    @PostMapping("/updateUser")
    public ResponseEntity<Map<String, String>> updateUser(@RequestBody Contacts contact) {
        contactRepository.updateUser(contact.getName(), contact.getEmail(), contact.getPhoneNumber());
        Map<String, String> response = new HashMap<>();
        response.put("Status", "Success");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/deleteUser")
    public ResponseEntity<Map<String, String>> deleteUser(@RequestBody Contacts contact) {
        contactRepository.deleteUser(contact.getEmail());
        Map<String, String> response = new HashMap<>();
        response.put("Status", "Success");
        return ResponseEntity.ok(response);
    }
}