package com.example.lms_prayekt.entity.teacher;

import com.example.lms_prayekt.entity.student.Student;
import com.example.lms_prayekt.type.Type;
import com.example.lms_prayekt.entity.sciences.entity.Sciences;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String Fullname;
    private Type type;
    @Column(nullable = false,unique = true)
    private String Login;
    @Column(nullable = false,unique = true)
    private String parol;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getParol() {
        return parol;
    }

    public void setParol(String parol) {
        this.parol = parol;
    }

    @ManyToOne
    private Sciences sciences;
    @ManyToMany
    @JoinTable(name = "teacher_student" ,
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Sciences getSciences() {
        return sciences;
    }

    public void setSciences(Sciences sciences) {
        this.sciences = sciences;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher() {
    }

    public Teacher(UUID id, String fullname, Type type, Sciences sciences, List<Student> students) {
        this.id = id;
        Fullname = fullname;
        this.type = type;
        this.sciences = sciences;
        this.students = students;
    }
}
