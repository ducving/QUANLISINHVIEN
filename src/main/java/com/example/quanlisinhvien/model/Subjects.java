package com.example.quanlisinhvien.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "subject")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;
//    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
//    private List<Result> results;

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
