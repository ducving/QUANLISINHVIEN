package com.example.quanlisinhvien.reponsitory;

import com.example.quanlisinhvien.model.ClassA;
import com.example.quanlisinhvien.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResultRepository extends JpaRepository<Result,Long> {
}
