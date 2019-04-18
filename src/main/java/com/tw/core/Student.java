package com.tw.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
    private String id;
    private String name;
    private HashMap<String, Double> allDisciplineScore;
    private Double averageScore;
    private Double totalScore;
    public List<String> disciplines = Arrays.asList("数学", "语文", "英语", "编程");

    public Student() {
    }

    public Student(String id, String name, HashMap allDisciplineScore) {
        this.id = id;
        this.name = name;
        this.allDisciplineScore = allDisciplineScore;
        setTotalScore();
        setAverageScore();
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore() {
        this.totalScore = disciplines.stream()
                .mapToDouble(discipline -> allDisciplineScore.get(discipline)).sum();
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore() {
        this.averageScore = totalScore / disciplines.size();
    }

    public HashMap getAllDisciplineScore() {
        return allDisciplineScore;
    }

    public void setAllDisciplineScore(HashMap allDisciplineScore) {
        this.allDisciplineScore = allDisciplineScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingleStudentScore() {
        String scores = disciplines.stream()
                .map(discipline -> remove0AferDecimalPoint(allDisciplineScore.get(discipline)))
                .collect(Collectors.joining("|"));
        String averageScoreStr = remove0AferDecimalPoint(averageScore);
        String totalScoreStr = remove0AferDecimalPoint(totalScore);
        return name + "|" + scores + "|" + averageScoreStr + "|" + totalScoreStr;
    }

    public String getDisciplineNames() {
        return String.join("|", disciplines);
    }

    private String remove0AferDecimalPoint(Double totalScore) {
        return totalScore % 1.0 == 0 ? String.valueOf(totalScore.longValue()) : String.valueOf(totalScore);
    }
}
