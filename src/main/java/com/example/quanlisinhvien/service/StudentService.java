package com.example.quanlisinhvien.service;

import com.example.quanlisinhvien.dto.PaginateRequest;
import com.example.quanlisinhvien.dto.StudentDto;
import com.example.quanlisinhvien.dto.StudentSpec;
import com.example.quanlisinhvien.model.Student;
import com.example.quanlisinhvien.reponsitory.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements  IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
 @Override
    public IStudentRepository studentRepos() {
        return studentRepository;
    }


    @Override
    public Page<Student> findAll(StudentDto studentDto, PaginateRequest paginateRequest) {
        return studentRepository.findAll(new StudentSpec(studentDto),
                PageRequest.of(paginateRequest.getPage(),paginateRequest.getSize()).withSort(Sort.by(paginateRequest.getDirection(),paginateRequest.getSortBy())));
    }


}
