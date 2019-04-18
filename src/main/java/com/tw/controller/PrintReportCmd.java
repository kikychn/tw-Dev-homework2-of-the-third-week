package com.tw.controller;

import com.tw.controller.exception.InputErrorException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PrintReportCmd {

    public List<String> parseStudentId(String input) {
        String[] studentIdsArr = input.split(",");
        List<String> studentIds = Arrays.asList(studentIdsArr).stream()
                .filter(i -> Pattern.matches("^\\d+$", i))
                .collect(Collectors.toList());

        if (studentIds.size() == 0) {
            throw new InputErrorException("Student Id input error");
        }
        return studentIds;
    }
}
