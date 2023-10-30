package com.example.lms_prayekt.entity.student;

import com.example.lms_prayekt.entity.lesson.entity.Lesson;
import com.example.lms_prayekt.type.Type;
import com.example.lms_prayekt.entity.sciences.entity.Sciences;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    private UUID id;
    private String name;
    private String Surname;
     private Type UserType;
     private String login;
     private String password;
     @ManyToMany
     @JoinTable(name = "student_sciences" ,
     joinColumns = @JoinColumn(name = "student_id"),
     inverseJoinColumns = @JoinColumn(name = "sciences_id"))
    private List<Sciences>sciences;
}
