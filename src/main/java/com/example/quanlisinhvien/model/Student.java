package com.example.quanlisinhvien.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name="student")
@EntityListeners(AuditingEntityListener.class)
public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank(message = "tên không được dể trống")
        private String name;

        @NotBlank(message = "giới tính không được dể trống")
        private String gender;
        @NotBlank(message = "ngày sinh không được dể trống")
        private String date0fBirth;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_classA",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "classA_id"))
    private List<ClassA> classA;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_subjects",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subjects_id"))
    private List<Subjects> subjects;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_department",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private List<Department> department;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Result> results;


    public Student(Long id, String name, String gender, String date0fBirth, List<ClassA> classA, List<Subjects> subjects, List<Department> department, List<Result> results) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date0fBirth = date0fBirth;
        this.classA = classA;
        this.subjects = subjects;
        this.department = department;
        this.results = results;
    }

    public List<ClassA> getClassA() {
        return classA;
    }

    public void setClassA(List<ClassA> classA) {
        this.classA = classA;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Student() {
    }
    public Student(Long id, String name, String gender, String date0fBirth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date0fBirth = date0fBirth;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate0fBirth() {
        return date0fBirth;
    }

    public void setDate0fBirth(String date0fBirth) {
        this.date0fBirth = date0fBirth;
    }
}
