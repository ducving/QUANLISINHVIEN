package com.example.quanlisinhvien.controller.api;

import com.example.quanlisinhvien.dto.PaginateRequest;
import com.example.quanlisinhvien.dto.StudentDto;
import com.example.quanlisinhvien.model.Student;
import com.example.quanlisinhvien.reponsitory.IDepartmentRepository;
import com.example.quanlisinhvien.reponsitory.IStudentRepository;
import com.example.quanlisinhvien.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@CrossOrigin
//
@RestController("apiStudentController")
@RequestMapping(value = "/api/v1")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private IDepartmentRepository iDepartmentRepository;

    @GetMapping("/student")
    public ResponseEntity<List<Student>> findAll(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "gender", required = false) String gender,
            @RequestParam(name = "date0fBirth", required = false) String date0fBirth,
            @RequestParam(name = "sortBy", required = false, defaultValue = "createdAt") String sortBy,
            @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction,Model model)
    {
        StudentDto studentDto = new StudentDto().setName(name).setGender(gender).setDate0fBirth(date0fBirth);
        PaginateRequest paginateRequest= new PaginateRequest(page,size);
        paginateRequest.setSortBy(sortBy);
        paginateRequest.setDirection(direction);
        Page<Student>pages=studentService.findAll(studentDto,paginateRequest);
        return new ResponseEntity<>(pages.getContent(), HttpStatus.OK);
    }


    @PostMapping("/create")
    private ResponseEntity<Student> save(@Valid @RequestBody StudentDto dto) {
        Student student=studentService.studentRepos().save(dto.toStudent());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") Long id, @Valid @RequestBody StudentDto dto) {
        if (studentService.studentRepos().findById(id).isPresent()) {
            Student student = studentService.studentRepos().findById(id).get();
            student.setGender(dto.getGender());
            student.setName(dto.getName());
            student.setDate0fBirth(dto.getDate0fBirth());
            studentService.studentRepos().save(student);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }

        return new ResponseEntity<>(false,HttpStatus.OK);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        if (studentService.studentRepos().findById(id).isPresent()) {
            studentService.studentRepos().deleteById(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.OK);
    }

}
