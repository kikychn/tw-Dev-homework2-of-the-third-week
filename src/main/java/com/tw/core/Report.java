package com.tw.core;

import java.util.List;
import java.util.stream.Collectors;

public class Report {
    private List<Student> students;
    private Double classTotalAverage;
    private Double classMedianScore;

    public Report(List<Student> students) {
        this.students = students;
        this.classTotalAverage = setClassTotalAverage();
        this.classMedianScore = setClassMedianScore();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Double getClassTotalAverage() {
        return classTotalAverage;
    }

    public Double setClassTotalAverage() {
        return students.stream().mapToDouble(student -> student.getAverageScore()).sum() / students.size();
    }

    public Double getClassMedianScore() {
        return classMedianScore;
    }

    public Double setClassMedianScore() {
        List<Double> studentsSortedByTotalScore = students.stream().map(student -> student.getTotalScore()).sorted().collect(Collectors.toList());
        int length = studentsSortedByTotalScore.size();
        if (length % 2 == 0) {
            return (studentsSortedByTotalScore.get(length / 2 - 1) + studentsSortedByTotalScore.get(length / 2)) / 2;
        } else {
            return studentsSortedByTotalScore.get((length - 1) / 2);
        }
    }
}
