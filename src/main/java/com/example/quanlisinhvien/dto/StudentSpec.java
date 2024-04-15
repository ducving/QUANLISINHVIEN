package com.example.quanlisinhvien.dto;

import com.example.quanlisinhvien.model.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class StudentSpec implements Specification<Student> {
    private StudentDto studentDto;

    public StudentSpec(StudentDto studentDto) {
        this.studentDto = studentDto;
    }


    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates=new ArrayList<Predicate>();
        if (studentDto.getName() != null) {
            predicates.add(
                    criteriaBuilder.like(root.get("name"),
                            "%" + studentDto.getName() + "%"));
        }

        if (studentDto.getGender() != null) {
            predicates.add(
                    criteriaBuilder.like(root.get("gender"),
                            "%"+studentDto.getGender()+"%"));
        }

        if (studentDto.getDate0fBirth() != null) {
            predicates.add(
                    criteriaBuilder.like(root.get("date0fBirth"),
                            "%"+studentDto.getDate0fBirth()+"%"));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
