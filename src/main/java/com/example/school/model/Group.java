package com.example.school.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int id;
    private String name;
    private List<Student> students;

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }

    public List<Student> getStudents() {
        return this.students;
    }

    // Getters and setters for id and name
}
