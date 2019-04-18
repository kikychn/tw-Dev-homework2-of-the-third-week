package com.tw.view;

import java.util.ArrayList;
import java.util.HashMap;

public class MainMenuPage {
    private static HashMap<String, String> MAINMENU = new HashMap<>();

    {
        MAINMENU.put("1", "添加学生");
        MAINMENU.put("2", "生成成绩单");
        MAINMENU.put("3", "退出请输入你的选择（1～3）：");
    }

    public String printMainMenu() {
        ArrayList<String> commandsStr = new ArrayList<>();
        for (String commandId : MAINMENU.keySet()) {
            commandsStr.add(commandId + ". " + MAINMENU.get(commandId));
        }
        return String.join("\n", commandsStr);
    }

}
