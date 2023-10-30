package com.example.lms_prayekt.entity.lesson.repozitary;

import com.example.lms_prayekt.entity.lesson.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LessonRepozitary extends JpaRepository<Lesson, UUID> {
}
