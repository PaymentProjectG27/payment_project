package com.example.lms_prayekt.security;


import com.example.lms_prayekt.entity.student.controller.StudentRepazitory;
import com.example.lms_prayekt.entity.teacher.TeacherRepazitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthController {
   private final StudentRepazitory repazitory;
    private final TeacherRepazitory teacherRepazitory;
    @GetMapping("/login")
    public String login() {
        return "/login";
    }

}
