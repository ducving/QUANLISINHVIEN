package com.example.quanlisinhvien.reponsitory;

import com.example.quanlisinhvien.model.ClassA;
import com.example.quanlisinhvien.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectRepository extends JpaRepository<Subjects,Long> {
}
