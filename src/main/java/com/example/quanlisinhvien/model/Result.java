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
