package com.example.lms_prayekt.admin;

import com.example.lms_prayekt.entity.lesson.entity.Lesson;
import com.example.lms_prayekt.entity.lesson.repozitary.LessonRepozitary;
import com.example.lms_prayekt.entity.sciences.entity.Sciences;
import com.example.lms_prayekt.entity.sciences.repozitary.SciencesRepazitory;
import com.example.lms_prayekt.entity.student.controller.StudentRepazitory;
import com.example.lms_prayekt.entity.teacher.Teacher;
import com.example.lms_prayekt.entity.teacher.TeacherRepazitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class adminController {
    private final TeacherRepazitory repozitary;
    private final SciencesRepazitory sciencesRepazitory;
    private final LessonRepozitary lessonRepozitary;
    static UUID uuid;
    @GetMapping
public ModelAndView getAll(Model model)
    {
        model.addAttribute(repozitary.findAll());
        return new ModelAndView("lessonAdmin",model.asMap());
    }
    @PostMapping("/{id}")
    public ModelAndView postLesson(@PathVariable("id") UUID id, Model model)
    {
      uuid=id;
        Sciences sciences = sciencesRepazitory.findById(id).get();
        model.addAttribute(sciences);
        return new ModelAndView("Time",model.asMap());
    }
    @PostMapping
    public ModelAndView postTimeLesson(@RequestParam("day")Integer day,
    @RequestParam("hour")Integer hour,@RequestParam("minut")Integer minut)
    {
        System.out.println(day);
        Sciences sciences = sciencesRepazitory.findById(uuid).get();
        Lesson lesson = new Lesson(UUID.randomUUID(), hour, minut, sciences);
        lessonRepozitary.save(lesson);
        return  new ModelAndView("Time");
    }
}
