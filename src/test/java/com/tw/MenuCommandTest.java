package com.tw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void should_command_format_is_right() {
        String command1 = "张三, 1, 学科: 80, 70, 60, 50";
        String command2 = "张三, 学科: 80, 70, 60, 50";
        String command3 = "张三, 1, 学科: 80, 70, 50";
        assertTrue(mainManu.checkCommandFormat("1", command1));
        assertFalse(mainManu.checkCommandFormat("1", command2));
        assertFalse(mainManu.checkCommandFormat("1", command3));
        String command4 = "1, 2";
        String command5 = "1, 2,";
        String command6 = "1, 2, m";
        assertTrue(mainManu.checkCommandFormat("2",command4));
        assertTrue(mainManu.checkCommandFormat("2",command5));
        assertFalse(mainManu.checkCommandFormat("2",command6));
    }
}
