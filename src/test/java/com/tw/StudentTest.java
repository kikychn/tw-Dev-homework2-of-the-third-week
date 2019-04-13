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

}
