package com.example.lms_prayekt.entity.lesson;


import com.example.lms_prayekt.entity.lesson.repozitary.LessonRepozitary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {
    private final LessonRepozitary lessonRepozitary;

}
