package com.contactmanagementsystem.contactmanagementsystem.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("phoneNumber")
    private String phoneNumber;  // Changed from Long to String ✅

    @JsonProperty("email")
    private String email;

    public Contacts(Long id, Long userId, String name, String phoneNumber, String email) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }  // Updated Getter ✅
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }  // Updated Setter ✅

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Contacts() { }
}
