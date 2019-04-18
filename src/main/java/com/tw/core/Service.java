package com.tw.core;

import com.tw.controller.AddStudentCmd;
import com.tw.controller.PrintReportCmd;
import com.tw.controller.exception.InputErrorException;
import com.tw.controller.exception.StudentNotFoundException;
import com.tw.repo.StudentRepo;
import com.tw.repo.StudentRepolmpl;
import com.tw.view.AddStudentPage;
import com.tw.view.MainMenuPage;
import com.tw.view.PrintReportPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Service {

    private static StudentRepo studentRepo = new StudentRepolmpl();

    public void printMainMenu() {
        MainMenuPage mainMenuPage = new MainMenuPage();
        System.out.println(mainMenuPage.printMainMenu());
    }

    public void addStudent() {
        AddStudentPage addStudentPage = new AddStudentPage();
        System.out.println(addStudentPage.PROMPT_INPUT);
        Scanner in = new Scanner(System.in);
        AddStudentCmd addStudentCmd = new AddStudentCmd();
        while (true) {
            try {
                Student student = addStudentCmd.parseStudent(in.nextLine());
                studentRepo.save(student);
                System.out.format(addStudentPage.SUCCESS_ADDITION, student.getName());
                break;
            } catch (InputErrorException e) {
                System.out.println(addStudentPage.PROMPT_ERROR_INPUT);
            }
        }
    }

    public void printReport() {
        PrintReportPage printReportPage = new PrintReportPage();
        System.out.println(printReportPage.PROMPT_INPUT);
        Scanner in = new Scanner(System.in);
        PrintReportCmd printReportCmd = new PrintReportCmd();
        while (true) {
            try {
                List<String> studentIds = printReportCmd.parseStudentId(in.nextLine());
                String disciplineNames = studentRepo.findByStudentId(studentIds.get(0)).getDisciplineNames();
                List<Student> students = new ArrayList<>();
                for (String studentId : studentIds) {
                    students.add(studentRepo.findByStudentId(studentId));
                }
                Report report = new Report(students);
                String studentsScoreStr = students.stream().map(student -> student.getSingleStudentScore()).collect(Collectors.joining("\n"));

                System.out.format(printReportPage.REPORT_TEMPLATE, disciplineNames, studentsScoreStr, report.getClassTotalAverage(), report.getClassMedianScore());
                break;
            } catch (InputErrorException e) {
                System.out.println(printReportPage.PROMPT_ERROR_INPUT);
            } catch (StudentNotFoundException e) {
                System.out.println(printReportPage.PROMPT_ERROR_Student_Not_Found);
            }
        }
    }
}
