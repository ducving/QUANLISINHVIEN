package com.example.quanlisinhvien.controller;

import com.example.quanlisinhvien.model.Subjects;
import com.example.quanlisinhvien.reponsitory.IResultRepository;
import com.example.quanlisinhvien.reponsitory.IStudentRepository;
import com.example.quanlisinhvien.reponsitory.ISubjectRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.Subject;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private ISubjectRepository iSubjectRepository;
    @Autowired
    private IStudentRepository studentRepository;

    @GetMapping()
    public ModelAndView findAll() {
        ModelAndView model = new ModelAndView("/subject/home");
        model.addObject("subject", iSubjectRepository.findAll());
        return model;
    }

    @GetMapping("/create")
    public ModelAndView formCreate() {
        ModelAndView model = new ModelAndView("subject/create");
        model.addObject("create", new Subjects());
        return model;
    }

    @PostMapping("/save")
    private ModelAndView save(Subjects subjects,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            ModelAndView model = new ModelAndView("subject/create");
            model.addObject("a", bindingResult.getAllErrors());
            return model;
        }
        ModelAndView modelAndView = new ModelAndView("subject/create");
        iSubjectRepository.save(subjects);
        return modelAndView;
    }
}
