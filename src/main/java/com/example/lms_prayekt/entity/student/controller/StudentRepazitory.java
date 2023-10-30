package com.example.lms_prayekt.entity.student.controller;

import com.example.lms_prayekt.entity.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface StudentRepazitory extends JpaRepository<Student, UUID> {
    Student getByLogin(String login);
}
