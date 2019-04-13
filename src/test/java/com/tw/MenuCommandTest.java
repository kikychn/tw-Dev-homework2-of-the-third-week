package com.tw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuCommandTest {
    MenuCommand mainManu;

    @Before
    public void setUp() throws Exception {
        mainManu = new MenuCommand();
    }

    @Test
    public void should_menuCommand_print_mainMenu() {
        String expexted = "1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：";
        assertEquals(expexted, mainManu.printMainMenu());
    }

    @Test
    public void should_print_reminderMessage_after_first_input_commandId() {
        assertEquals("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：", mainManu.printReminderMessage("2"));
    }
}
