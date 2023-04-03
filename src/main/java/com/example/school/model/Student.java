package com.example.school.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carine Iradukunda
 */

public class Student {
    private int id;
    private String name;
    private List<Class> classes;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.classes = new ArrayList<>();
    }

    public void addClass(Class c) {
        this.classes.add(c);
    }

    public List<Class> getClasses() {
        return this.classes;
    }

    public String getClassName() {
        return this.classes.toString();
    }

    public String getName() {
        return this.name;
    }

    public List<Class> getSubjectNames() {
        return this.classes;
    }

    // Getters and setters for id and name

}

