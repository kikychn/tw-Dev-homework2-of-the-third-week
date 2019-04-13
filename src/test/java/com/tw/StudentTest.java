package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    @Test
    public void should_student_have_id_name() {
        Student student = new Student(1, "Tom");
        assertEquals(1, student.getId());
        assertEquals("Tom",student.getName());
    }

    @Test
    public void should_discipline_have_id_name() {
        Discipline discipline = new Discipline(1, "数学");
        assertEquals(1, discipline.getId());
        assertEquals("数学",discipline.getName());
    }
}
