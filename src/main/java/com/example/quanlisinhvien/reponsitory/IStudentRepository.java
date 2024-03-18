package com.example.quanlisinhvien.reponsitory;

import com.example.quanlisinhvien.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {
}
