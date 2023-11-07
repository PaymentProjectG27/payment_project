package com.example.lms_prayekt.entity.teacher;

import com.example.lms_prayekt.entity.student.Student;
import com.example.lms_prayekt.entity.student.StudentService;
import com.example.lms_prayekt.entity.teacher.dto.FileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {


    private final TeacherService teacherService;

    private final StudentService studentService;

    @GetMapping("/fanlarim")
    public ModelAndView fan() {

        return new ModelAndView("teacher/fanlarim");
    }

    @GetMapping("/davomat")
    public ModelAndView davomat(Model model) {

        List<Student> userStuden = studentService.getAll();
        model.addAttribute("userStuden", userStuden);
        return new ModelAndView("teacher/davomat");
    }

    @PostMapping("/update/{id}")
    public ModelAndView mb(@PathVariable UUID id) {
        studentService.mbUpdate(id);
        return new ModelAndView("teacher/mb");
    }


//    @GetMapping("/file")
//    public String f(){
//
//
//    }


 /*   @PostMapping("/file")
    public ModelAndView file(@ModelAttribute FileDto fileDto) throws IOException {

        try {
            MultipartFile file = fileDto.getFile();
            file.getOriginalFilename();
            Path path = Path
                    .of("src/main/resources/static/file/" + file.getOriginalFilename());
            Files.write(path, file.getBytes());
        } catch (AccessDeniedException e) {
            return new ModelAndView("teacher/failed");
        }


        return new ModelAndView("teacher/file");
    }*/


    @PostMapping("/file")
    public ModelAndView file(@ModelAttribute FileDto fileDto) throws IOException, SQLException {


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sardor", "postgres", "sardor2003");
        String sql = "INSERT INTO files (file_name, file_data) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, fileDto.getFile().getOriginalFilename());
        statement.setBytes(2, fileDto.getFile().getBytes());
        statement.executeUpdate();
        connection.close();


        return new ModelAndView("teacher/file");
    }


    @GetMapping("/meningFanlarim")
    public ModelAndView file(Model model) {


        return new ModelAndView("teacher/MyFanlarim");


    }


}





