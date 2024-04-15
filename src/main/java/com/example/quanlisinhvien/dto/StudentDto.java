package com.example.quanlisinhvien.dto;

import com.example.quanlisinhvien.model.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class StudentDto {
    @NotEmpty
    @NotBlank(message = "tên không được dể trống")
    @NotNull
    private String name;
    @NotBlank(message = "giới tính không được dể trống")
    private String gender;
    @NotBlank(message = "ngày sinh không được dể trống")
    private String date0fBirth;

    public Student toStudent(){
        Student student = new Student();
        student.setName(name);
        student.setGender(gender);
        student.setDate0fBirth(date0fBirth);
        return student;
    }

    public String getName() {
        return name;
    }

    public StudentDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public StudentDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getDate0fBirth() {
        return date0fBirth;
    }

    public StudentDto setDate0fBirth(String date0fBirth) {
        this.date0fBirth = date0fBirth;
        return this;
    }
}
