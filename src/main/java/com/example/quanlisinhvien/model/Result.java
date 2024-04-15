package com.example.quanlisinhvien.model;

import jakarta.persistence.*;


@Entity
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int points;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student  student;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subjects  subject;

    public Result(Long id, int points, Student student, Subjects subject, Department department) {
        this.id = id;
        this.points = points;
        this.student = student;
        this.subject = subject;
        this.department = department;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public Result(Long id, int points, Student student, Department department) {
        this.id = id;
        this.points = points;
        this.student = student;
        this.department = department;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department  department;

    public Result(Long id, int points) {
        this.id = id;
        this.points = points;
    }

    public Result() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
