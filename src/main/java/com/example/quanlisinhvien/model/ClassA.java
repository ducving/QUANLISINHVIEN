package com.example.quanlisinhvien.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "classA")
public class ClassA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "classA")
    private List<Student> students;
    public ClassA() {
    }
    public ClassA(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClassA(Long id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

