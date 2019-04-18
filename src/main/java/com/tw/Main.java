package com.tw;

import com.tw.core.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.printMainMenu();
        Scanner in = new Scanner(System.in);
        while (true) {
            switch (in.nextLine()) {
                case "1":
                    service.addStudent();
                    break;
                case "2":
                    service.printReport();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    service.printMainMenu();
            }
        }

    }
}
