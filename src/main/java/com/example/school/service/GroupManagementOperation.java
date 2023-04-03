package com.example.school.service;

import com.example.school.model.Class;
import com.example.school.model.Student;
import com.example.school.model.Subject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class GroupManagementOperation implements GroupManagementOperator{

    private final Map<String, List<Student>> groups; // Map of group names to student lists
    private final List<Student> unplacedStudents; // List of unplaced students

    // Constructor
    public GroupManagementOperation() {
        this.groups = new HashMap<>();
        this.unplacedStudents = new ArrayList<>();
    }

    // Add a student to the list of unplaced students
    @Override
    public void addUnplacedStudent(Student student) {
        unplacedStudents.add(student);
    }

    // Add a group to the map
    @Override
    public void addGroup(String groupName) {
        groups.put(groupName, new ArrayList<>());
    }

    // Add a student to a group
    public void addStudentToGroup(Student student, String groupName) {
        List<Student> group = groups.get(groupName);
        if (group != null) {
            group.add(student);
        } else {
            System.out.println("Group " + groupName + " does not exist.");
        }
    }

    @Override
    // Populate groups based on subject and class
    public void populateGroups(List<Student> students, List<Subject> subjects, List<Class> classes, int minGroupSize, int maxGroupSize) {
        // Map students to classes
        Map<String, List<Student>> studentsByClass = new HashMap<>();
        for (Class c : classes) {
            studentsByClass.put(c.getName(), new ArrayList<>());
        }
        for (Student s : students) {
            String className = s.getClassName();
            if (studentsByClass.containsKey(className)) {
                studentsByClass.get(className).add(s);
            } else {
                System.out.println("Student " + s.getName() + " is in an unknown class.");
            }
        }
        // Map subjects to students
        Map<String, List<Student>> studentsBySubject = new HashMap<>();
        for (Subject s : subjects) {
            studentsBySubject.put(s.getName(), new ArrayList<>());
        }
        for (Student s : students) {
            List<Class> subjectNames = s.getSubjectNames();
            for (Class subjectName : subjectNames) {
                if (studentsBySubject.containsKey(subjectName)) {
                    studentsBySubject.get(subjectName).add(s);
                } else {
                    System.out.println("Student " + s.getName() + " is enrolled in an unknown subject.");
                }
            }
        }
        // Create groups
        for (Subject s : subjects) {
            String subjectName = s.getName();
            int numGroups = (int) Math.ceil((double) studentsBySubject.get(subjectName).size() / maxGroupSize);
            for (int i = 1; i <= numGroups; i++) {
                String groupName = subjectName + "-" + i;
                addGroup(groupName);
            }
            for (Class c : classes) {
                String className = c.getName();
                List<Student> studentsInClass = studentsByClass.get(className);
                List<Student> studentsInSubject = studentsBySubject.get(subjectName);
                for (Student student : studentsInClass) {
                    if (studentsInSubject.contains(student)) {
                        String groupName = getAvailableGroup(subjectName, minGroupSize, maxGroupSize);
                        if (groupName != null) {
                            addStudentToGroup(student, groupName);
                        } else {
                            addUnplacedStudent(student);
                        }
                    }
                }
            }
        }
    }

    @Override
    public String getAvailableGroup(String subjectName, int minGroupSize, int maxGroupSize) {
        return subjectName;
    }
    }

    // Get the name of an available group for a subject, or null if none are available

