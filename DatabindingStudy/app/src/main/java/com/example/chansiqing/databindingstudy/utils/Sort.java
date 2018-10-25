package com.example.chansiqing.databindingstudy.utils;

/**
 * 同排序求最大相邻差值
 * @author: xieli
 * @date: 2018-10-18 19:18
 */
public class Sort {
    /**
     * 求无需数组有序情况下相邻元素差值的最大值
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int fun(int[] array, int n) {

        int i, j;
        int min = array[0], max = array[0];
        int result = Integer.MIN_VALUE; //记录相邻最大差值
        //区间划分数组 每个数组元素记录区间的最小值和最大值 及是否是空区间
        Item[] b = new Item[n + 1];
        // Item[] b = new Item[n];
        double step; //区间长度

        // 第一次遍历 得出原数组的最大值和最小值  O(n)
        for (i = 0; i < n; i++) {
            if (array[i] < min)
                min = array[i];
            if (array[i] > max)
                max = array[i];
        }

        step = (max - min) * 1.0 / n;
        for (i = 0; i < n + 1; i++)
            b[i] = new Item();
        //第二次遍历 将元素映射到对应区间 记录每个区间的最值及是否为空情况 O(n)
        for (i = 0; i < n; i++) {
            j = (int) (array[i] / step);
            b[j].flag = true;
            if (b[j].min > array[i])
                b[j].min = array[i];
            if (b[j].max < array[i])
                b[j].max = array[i];
        }

        Item temp = new Item();

        //遍历b数组，求出相邻非空区间差值的最大值 O(n)
        for (j = 0; j < n + 1; j++) {
            //如果区间为空则继续
            if (!b[j].flag)
                continue;
            else {
                if (!temp.flag) {
                    temp = b[j];
                    continue;
                } else {
                    if (b[j].min - temp.max > result)
                        result = b[j].min - temp.max;
                    temp = b[j];
                }
            }
        }
        return result;
    }

    static class Item {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
    }

    public int test() {
        int[] arr = {10, 1, 3, 5, 4};
        int result = fun(arr, arr.length);
        return result;
    }
}
