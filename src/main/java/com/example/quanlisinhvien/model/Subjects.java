package com.example.quanlisinhvien.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
@Entity
@Table(name = "subject")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "yêu cầu phải chọn môn học ")
    private String name;
    private String teacher;
    private String description;



    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Result> results;

    public Subjects(Long id, String name, List<Student> students, List<Result> results) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.results = results;
    }

    public Subjects(Long id, String name, String teacher, String description, List<Student> students, List<Result> results) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.description = description;
        this.students = students;
        this.results = results;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Subjects() {
    }
    public Subjects(Long id, String name) {
        this.id = id;
        this.name = name;
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
