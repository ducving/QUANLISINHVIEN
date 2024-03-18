package com.example.quanlisinhvien.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String student_name;
    private String gender;
    private String date0fBirth;

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



    public Student() {
    }
    public Student(Long id, String student_name, String gender, String date0fBirth) {
        this.id = id;
        this.student_name = student_name;
        this.gender = gender;
        this.date0fBirth = date0fBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
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
