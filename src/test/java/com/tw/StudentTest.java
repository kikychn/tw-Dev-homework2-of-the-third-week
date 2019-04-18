package com.tw;

import com.tw.core.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    private Student student;

    @Before
    public void setUp() {
        HashMap<String, Double> score = new HashMap();
        score.put("数学", 75.0);
        score.put("语文", 95.0);
        score.put("英语", 80.0);
        score.put("编程", 80.0);
        student = new Student("1", "张三", score);
    }

    @Test
    public void should_student_have_id_name() {
        assertEquals("1", student.getId());
        assertEquals("张三", student.getName());
        assertEquals(75.0, student.getAllDisciplineScore().get("数学"));
    }

    @Test
    public void should_student_have_totalScore() {
        Double expected = 330.0;
        assertEquals(expected, student.getTotalScore());
    }

    @Test
    public void should_student_have_averageScore() {
        Double expected = 82.5;
        assertEquals(expected, student.getAverageScore());
    }

    @Test
    public void should_student_have_an_introduce_method() {
        String expected = "张三|75|95|80|80|82.5|330";
        assertEquals(expected, student.getSingleStudentScore());
    }

}
