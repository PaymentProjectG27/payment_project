package com.example.lms_prayekt.entity.student.controller;

import com.example.lms_prayekt.entity.sciences.repozitary.SciencesRepazitory;
import com.example.lms_prayekt.entity.teacher.TeacherRepazitory;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final SciencesRepazitory repazitory;
    private final StudentRepazitory studentRepazitory;
    private final TeacherRepazitory teacherRepazitory;
    @GetMapping
    public ModelAndView getMenu(Model model)
    {
      return new ModelAndView("Sciences",model.asMap());
    }
}
