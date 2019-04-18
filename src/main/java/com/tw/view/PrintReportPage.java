package com.tw.view;

public class PrintReportPage {
    public static String PROMPT_INPUT = "请输入要打印的学生的学号(格式: 学号, 学号,...), 按回车提交:";
    public static String PROMPT_ERROR_INPUT = "请按正确的格式输入要打印的学生的学号(格式: 学号, 学号,...), 按回车提交:";
    public static String PROMPT_ERROR_Student_Not_Found = "对应学号学生不存在,请输入正确学生的学号(格式: 学号, 学号,...)， 按回车提交:";
    public static String REPORT_TEMPLATE = "\n成绩单\n"
            + "姓名|%s|平均分|总分\n"
            + "========================\n"
            + "%s"
            + "\n========================\n"
            + "全班总分平均分: %.2f\n"
            + "全班总分中位数: %.2f\n";

}
