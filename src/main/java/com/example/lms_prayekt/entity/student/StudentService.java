package com.example.lms_prayekt.entity.student;

import com.example.lms_prayekt.entity.student.controller.StudentRepazitory;
import com.example.lms_prayekt.type.Type;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepazitory studentRepazitory;

    public List<Student> getAll() {
        List<Student> all = studentRepazitory.findAll();
        return all;
    }

    @Transactional
    public Student mbUpdate(UUID id) {
        Student student1 = studentRepazitory.findById(id).get();
        Integer mb = student1.getMb();
        mb = mb + 1;
        student1.setMb(mb);

      /*  Student student = new Student(student1.getId(),student1.getName(),student1.getSurname()
        ,student1.getUserType(),student1.getLogin(),student1.getPassword(),mb,student1.getSciences()
        ,student1.getTeachers());

        student1 = studentRepazitory.save(student);*/
        return student1;

    }


}
