package com.example.quanlisinhvien.reponsitory;


import com.example.quanlisinhvien.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department,Long> {
}
