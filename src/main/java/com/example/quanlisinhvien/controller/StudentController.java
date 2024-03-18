package com.example.quanlisinhvien.controller;

import com.example.quanlisinhvien.model.Student;
import com.example.quanlisinhvien.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping
    public ModelAndView findAll(){
        ModelAndView model = new ModelAndView("/student/view");
        model.addObject("student",studentService.findAll());
        return model;
    }

}
