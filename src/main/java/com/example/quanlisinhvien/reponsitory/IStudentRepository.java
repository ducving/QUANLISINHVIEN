package com.example.quanlisinhvien.reponsitory;

import com.example.quanlisinhvien.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IStudentRepository extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {
    Page<Student> findByNameContaining(String keyword, Pageable pageable);

}
