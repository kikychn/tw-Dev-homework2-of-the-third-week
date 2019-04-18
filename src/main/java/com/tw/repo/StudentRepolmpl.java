package com.tw.repo;

import com.tw.controller.exception.StudentNotFoundException;
import com.tw.core.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepolmpl implements StudentRepo {
    private static List<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public Student findByStudentId(String studentId) {
        for (Student student : students) {
            if (studentId.equals(student.getId())) {
                return student;
            }
        }
        throw new StudentNotFoundException("Student no Found");
    }

}
