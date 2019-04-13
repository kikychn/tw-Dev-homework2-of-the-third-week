package com.tw;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuCommand {
    public static HashMap<String, String> mainMenu = new HashMap<>();
    public static HashMap<String, String> reminderMessage = new HashMap<>();

    {
        mainMenu.put("1", "添加学生");
        mainMenu.put("2", "生成成绩单");
        mainMenu.put("3", "退出请输入你的选择（1～3）：");
        reminderMessage.put("1", "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
        reminderMessage.put("2", "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
        reminderMessage.put("3", "");
    }

    public String printMainMenu() {
        ArrayList<String> commandsStr = new ArrayList<>();
        for (String commandId : mainMenu.keySet()) {
            commandsStr.add(commandId + ". " + mainMenu.get(commandId));
        }
        return String.join("\n", commandsStr);
    }

    public String printReminderMessage(String commandId){
        return reminderMessage.get(commandId);
    }
}
