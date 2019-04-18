package com.tw.repo;

import com.tw.core.Student;

public interface StudentRepo {
    void save(Student student);

    Student findByStudentId(String studentId);

}
