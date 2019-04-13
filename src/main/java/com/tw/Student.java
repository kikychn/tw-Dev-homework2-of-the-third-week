package com.tw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
    private int id;
    private String name;
    private HashMap<String, Double> allDisciplineScore;
    private Double averageScore;
    private Double totalScore;
    public List<String> disciplines = Arrays.asList("数学", "语文", "英语", "编程");


    public Student(int id, String name, HashMap allDisciplineScore) {
        this.id = id;
        this.name = name;
        this.allDisciplineScore = allDisciplineScore;
        setTotalScore();
        setAverageScore();
    }

    public Double getTotalScore() {
        return totalScore;
    }

    private void setTotalScore() {
        this.totalScore = disciplines.stream()
                .mapToDouble(discipline -> allDisciplineScore.get(discipline)).sum();
    }

    public Double getAverageScore() {
        return averageScore;
    }

    private void setAverageScore() {
        this.averageScore = totalScore / disciplines.size();
    }

    public HashMap getAllDisciplineScore() {
        return allDisciplineScore;
    }

    public void setAllDisciplineScore(HashMap allDisciplineScore) {
        this.allDisciplineScore = allDisciplineScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String introduce() {
        String scores = disciplines.stream()
                .map(discipline -> allDisciplineScore.get(discipline) % 1.0 == 0
                        ? String.valueOf(allDisciplineScore.get(discipline).longValue())
                        : String.valueOf(allDisciplineScore.get(discipline)))
                .collect(Collectors.joining("|"));
        String averageScoreStr = averageScore % 1.0 == 0 ? String.valueOf(averageScore.longValue()) : String.valueOf(averageScore);
        String totalScoreStr = totalScore % 1.0 == 0 ? String.valueOf(totalScore.longValue()) : String.valueOf(totalScore);
        return name + "|" + scores + "|" + averageScoreStr + "|" + totalScoreStr;
    }
}
