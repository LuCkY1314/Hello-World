package com.example.chansiqing.databindingstudy;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {
        int i = 10;
        if (i++ > 10)
            System.out.println("正确，i = " + i);
        else
            System.out.println("错误，i = " + i);
    }
}