package com.example.lms_prayekt.admin.repozitary;

import com.example.lms_prayekt.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdminRepozitary extends JpaRepository<Admin, UUID> {
    Admin findByLogin(String login);
}
