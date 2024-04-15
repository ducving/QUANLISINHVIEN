package com.example.quanlisinhvien.controller;

import com.example.quanlisinhvien.dto.PaginateRequest;
import com.example.quanlisinhvien.dto.StudentDto;
import com.example.quanlisinhvien.model.Student;
import com.example.quanlisinhvien.reponsitory.IDepartmentRepository;
import com.example.quanlisinhvien.reponsitory.IStudentRepository;
import com.example.quanlisinhvien.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private IDepartmentRepository iDepartmentRepository;
    private StudentDto studentDto;

    @GetMapping("")
    public ModelAndView findAll(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                @RequestParam(name = "size", required = false, defaultValue = "5") int size,
                                @RequestParam(name = "name", required = false) String name,
                                @RequestParam(name = "gender", required = false) String gender,
                                @RequestParam(name = "date0fBirth", required = false) String date0fBirth,
                                @RequestParam(name = "sortBy", required = false, defaultValue = "createdAt") String sortBy,
                                @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction,
                                Model model) {
        ModelAndView modelAndView = new ModelAndView("student/home");
        Page<Student> students = studentService.findAll(
                new StudentDto().setGender(gender).setDate0fBirth(date0fBirth).setName(name),
                new PaginateRequest(page, size).setDirection(direction).setSortBy(sortBy));

        model.addAttribute("direction", direction);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("reverseDirection", direction.equals("asc") ? "desc" : "asc");
        model.addAttribute("pageBegin", Math.max(1, page));
        model.addAttribute("pageEnd", Math.min(page + 2, students.getTotalPages()));
        model.addAttribute("totalPages", students.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("students", students.getContent());
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView formCreate() {
        ModelAndView model = new ModelAndView("student/create");
        model.addObject("create", new Student());
        model.addObject("createDepartment", iDepartmentRepository.findAll());
        return model;
    }

    @PostMapping("save")
    private ModelAndView save(@Valid @ModelAttribute StudentDto dto, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        studentService.studentRepos().save(dto.toStudent());
        redirectAttributes.addFlashAttribute("msg", "Tạo mới sinh viên thành công");
        return modelAndView;
    }

    @GetMapping("update/{id}")
    public ModelAndView formUpdate(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("student/update");
        Student student = studentService.studentRepos().findById(id).get();
        model.addObject("update", student);
        return model;
    }

    @PostMapping("update/{id}")
    public ModelAndView update(@PathVariable("id") Long id, @Valid @ModelAttribute StudentDto dto,
                               RedirectAttributes redirectAttributes) {
        // LocalDateTime startDate = dto.getStartDate();
        // LocalDateTime endDate = dto.getEndDate();
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        if (studentService.studentRepos().findById(id).isPresent()) {
            Student student = studentService.studentRepos().findById(id).get();
            student.setGender(dto.getGender());
            student.setName(dto.getName());
            student.setDate0fBirth(dto.getDate0fBirth());
            studentService.studentRepos().save(student);
        }
        redirectAttributes.addFlashAttribute("msg", "Sửa sinh viên thành công");

        // redirectAttributes.addFlashAttribute("status", "error");
        return modelAndView;

    }

    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("redirect:/student");
       if( studentService.studentRepos().findById(id).isPresent()){
           studentService.studentRepos().deleteById(id);
       }
        return model;
    }

    //    @GetMapping("/search")
//    public ModelAndView search(@RequestParam("name") String name
//            , @PageableDefault(3) Pageable pageable){
//        ModelAndView model = new ModelAndView("student/search");
//        Iterable<Student> students =  studentRepository.findByNameContaining(name, pageable);
//        model.addObject("student",students);
//        model.addObject("name",name);
//        return model;
//    }


}
