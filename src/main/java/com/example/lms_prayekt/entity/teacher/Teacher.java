package com.example.lms_prayekt.entity.teacher;

import com.example.lms_prayekt.entity.student.Student;
import com.example.lms_prayekt.type.Type;
import com.example.lms_prayekt.entity.sciences.entity.Sciences;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String Fullname;

    private Type type;
    @Column(nullable = false, unique = true)
    private String Login;
    @Column(nullable = false, unique = true)
    private String parol;

    @ManyToOne
    private Sciences sciences;

    @ManyToMany
    @JoinTable(name = "teacher_student",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;


}
