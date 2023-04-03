package com.example.school.service;

import com.example.school.model.Class;
import com.example.school.model.Student;
import com.example.school.model.Subject;

import java.util.List;

/**
 * @author Carine Iradukunda
 */
public interface GroupManagementOperator {
    // Add a student to the list of unplaced students
    void addUnplacedStudent(Student student);

    // Add a group to the map
    void addGroup(String groupName);

    // Populate groups based on subject and class
    void populateGroups(List<Student> students, List<Subject> subjects, List<Class> classes, int minGroupSize, int maxGroupSize);

    String getAvailableGroup(String subjectName, int minGroupSize, int maxGroupSize);
}
