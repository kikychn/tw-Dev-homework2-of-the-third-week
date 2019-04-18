package com.tw.controller.exception;

public class StudentNotFoundException extends NullPointerException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
