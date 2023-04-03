package com.example.school.model;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private int id;
    private String name;
    private List<Subject> subjects;
    private List<Group> groups;

    public Class(int id, String name) {
        this.id = id;
        this.name = name;
        this.subjects = new ArrayList<>();
        this.groups = new ArrayList<>();
    }

    public void addSubject(Subject s) {
        this.subjects.add(s);
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void addGroup(Group g) {
        this.groups.add(g);
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    public String getName() {

        return this.name;
    }

    // Getters and setters for id and name
}
