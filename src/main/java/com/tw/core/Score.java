package com.tw.core;

import java.util.HashMap;

public class Score {
    HashMap<String, Double> allDisciplineScore;

    public Score(HashMap<String, Double> allDisciplineScore) {
        this.allDisciplineScore = allDisciplineScore;
    }

    public HashMap<String, Double> getAllDisciplineScore() {
        return allDisciplineScore;
    }

    public void setAllDisciplineScore(HashMap<String, Double> allDisciplineScore) {
        this.allDisciplineScore = allDisciplineScore;
    }
}
