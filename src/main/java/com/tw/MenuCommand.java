package com.tw;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuCommand {
    public static HashMap<String, String> mainMenu = new HashMap<>();

    {
        mainMenu.put("1", "添加学生");
        mainMenu.put("2", "生成成绩单");
        mainMenu.put("3", "退出请输入你的选择（1～3）：");
    }

    public String printMainMenu() {
        ArrayList<String> commandsStr = new ArrayList<>();
        for (String commandId : mainMenu.keySet()) {
            commandsStr.add(commandId + ". " + mainMenu.get(commandId));
        }
        return String.join("\n", commandsStr);
    }
}
