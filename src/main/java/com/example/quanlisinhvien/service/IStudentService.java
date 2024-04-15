package com.example.quanlisinhvien.service;

import com.example.quanlisinhvien.dto.PaginateRequest;
import com.example.quanlisinhvien.dto.StudentDto;
import com.example.quanlisinhvien.model.Student;
import com.example.quanlisinhvien.reponsitory.IStudentRepository;
import org.springframework.data.domain.Page;

public interface IStudentService  {
    Page<Student> findAll(StudentDto studentDto, PaginateRequest paginateRequest);
    IStudentRepository studentRepos();
}
