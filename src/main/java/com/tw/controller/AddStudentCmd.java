package com.tw.controller;

import com.tw.controller.exception.InputErrorException;
import com.tw.core.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AddStudentCmd {

    public Student parseStudent(String input) {
        try {
            List<String> studentInfo = new ArrayList<>(Arrays.asList(input.split(", ")));
            Student student = new Student();
            student.setName(studentInfo.get(0));
            student.setId(studentInfo.get(1));
            studentInfo.remove(0);
            studentInfo.remove(0);

            HashMap<String, Double> allDisciplineScore = new HashMap<>();
            for (String disciplineScore : studentInfo) {
                if (disciplineScore.equals(null)) continue;
                String[] disciplineScoreArr = disciplineScore.split(":");
                allDisciplineScore.put(disciplineScoreArr[0], Double.valueOf(disciplineScoreArr[1]));
            }
            student.setAllDisciplineScore(allDisciplineScore);
            student.setTotalScore();
            student.setAverageScore();
            return student;
        } catch (Exception e) {
            throw new InputErrorException("Student info input error");
        }
    }

}
