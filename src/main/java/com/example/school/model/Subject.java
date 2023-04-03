package com.example.school.model;

public class Subject {
    private int id;
    private String name;

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // Getters and setters for id and name
}
