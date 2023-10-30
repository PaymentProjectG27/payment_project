package com.example.lms_prayekt.entity.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TeacherRepazitory extends JpaRepository<Teacher, UUID> {

}
