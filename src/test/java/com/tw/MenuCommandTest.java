package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuCommandTest {
    @Test
    public void should_menuCommand_print_mainMenu() {
        MenuCommand mainManu = new MenuCommand();
        String expexted = "1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：";
        assertEquals(expexted, mainManu.printMainMenu());
    }
}
