package com.contactmanagementsystem.contactmanagementsystem.Repository;

import com.contactmanagementsystem.contactmanagementsystem.Models.Contacts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contacts, Long> {
    @Query(value = "SELECT * FROM contacts", nativeQuery = true)
    List<Contacts> viewAllUsers();

    @Modifying
    @Transactional
    @Query(value = "UPDATE contacts SET name = ?1, email = ?2 WHERE phone_number = ?3", nativeQuery = true)
    void updateUser(String name, String email, String phoneNumber);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM contacts WHERE email = ?1", nativeQuery = true)
    void deleteUser(String email);
}
