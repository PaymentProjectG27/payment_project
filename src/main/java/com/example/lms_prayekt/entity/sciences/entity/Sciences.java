package com.example.lms_prayekt.entity.sciences.entity;

import com.example.lms_prayekt.entity.lesson.entity.Lesson;
import com.example.lms_prayekt.entity.teacher.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Sciences {
    @Id
    private UUID id;
    private String name;
    private LocalDate date;
    private int freeLesson;
    private int accumulatedpoints;
    private int percentageoftotalscore;
     @OneToMany(mappedBy = "sciences",fetch = FetchType.LAZY)
    private List<Teacher>teachers;
    @OneToMany(mappedBy = "sciences",fetch = FetchType.LAZY)
   private List<Lesson>lessons;

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setFreeLesson(int freeLesson) {
        this.freeLesson = freeLesson;
    }

    public void setAccumulatedpoints(int accumulatedpoints) {
        this.accumulatedpoints = accumulatedpoints;
    }

    public void setPercentageoftotalscore(int percentageoftotalscore) {
        this.percentageoftotalscore = percentageoftotalscore;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
