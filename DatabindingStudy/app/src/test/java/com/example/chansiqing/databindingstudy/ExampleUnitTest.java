package com.example.chansiqing.databindingstudy;


import com.example.chansiqing.databindingstudy.utils.JDHomeNoUIThreadPool;

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
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("currentRunThreadNum " + JDHomeNoUIThreadPool.getCurrentRunThreadNum());
            }
        };
        for (int j = 0; j < 100; j++) {
            JDHomeNoUIThreadPool.addTask(runnable);
        }
        JDHomeNoUIThreadPool.addTask(runnable);
        JDHomeNoUIThreadPool.addTask(runnable);
        JDHomeNoUIThreadPool.destroy();
    }
}