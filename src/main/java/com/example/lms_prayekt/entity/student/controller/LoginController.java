package com.example.lms_prayekt.entity.student.controller;

import com.example.lms_prayekt.admin.Admin;
import com.example.lms_prayekt.admin.repozitary.AdminRepozitary;
import com.example.lms_prayekt.entity.sciences.entity.Sciences;
import com.example.lms_prayekt.entity.student.Student;
import com.example.lms_prayekt.entity.teacher.Teacher;
import com.example.lms_prayekt.entity.teacher.TeacherRepazitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class LoginController {
    private final StudentRepazitory studentRepazitory;
    private final TeacherRepazitory repazitory;
    private final AdminRepozitary adminrepozitary;
    private List<Sciences> sciences=new ArrayList<>();
    @PostMapping("/loginParol")
    public ModelAndView register(@RequestParam("Login")String login, Model model)
    {
        for (Teacher teacher : repazitory.findAll()) {
            if (teacher.getLogin().equals(login))
            {
                model.addAttribute(teacher);
                return new ModelAndView("Teacher",model.asMap());
            }
        }
        Student byLogin = studentRepazitory.getByLogin(login);

        if (byLogin!=null ){
         sciences = byLogin.getSciences();
        model.addAttribute(sciences);
        findLoginTeacher(login);
        return new ModelAndView("Dars",model.asMap());}
        else if (byLogin==null ) {
            Admin byLogin1 = adminrepozitary.findByLogin(login);
            model.addAttribute(byLogin1);
            return new ModelAndView("Admin",model.asMap());
        }
        return new ModelAndView("login");
    }

    private void findLoginTeacher(String login) {
        List<Teacher>teachers=new ArrayList<>();
        for (Sciences science : sciences) {
            for (Teacher teacher : science.getTeachers()) {
                for (Student student : teacher.getStudents()) {
                    if (student.getLogin().equals(login))
                    {
                        System.out.println("teacher.getFullname() = " + teacher.getFullname());
                        teachers.add(teacher);
                    }
                }
            }
        }
        for (Sciences science : sciences) {
            for (Teacher teacher : science.getTeachers()) {
                for (Student student : teacher.getStudents()) {
                    if (student.getLogin().equals(login))
                    {
                       science.setTeachers(teachers);
                    }
                }
            }
        }
        System.out.println("teachers = " + teachers.size());

    }
    @GetMapping("/jadval")
    public ModelAndView jadvalDars( Model model)
    {
        model.addAttribute(sciences);
        return new ModelAndView("test",model.asMap());
    }

    @PostMapping
    public ModelAndView getAll(Model model)
    {
        model.addAttribute(sciences);
        return new ModelAndView("TableDars",model.asMap());
    }
    @GetMapping("/data")
     private ModelAndView getAllData(Model model)
    {
        model.addAttribute(sciences);
        return new ModelAndView("TableDars",model.asMap());
    }
}
