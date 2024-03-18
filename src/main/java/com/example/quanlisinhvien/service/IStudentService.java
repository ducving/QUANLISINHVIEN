package com.example.quanlisinhvien.service;

import com.example.quanlisinhvien.model.Student;
import org.hibernate.query.Page;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
}
