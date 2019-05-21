package com.example.chansiqing.databindingstudy.utils;

import com.example.chansiqing.databindingstudy.datastructure.TreeNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 算法代码实现工具
 *
 * @author: chansiqing
 * @date: 2019-04-28 13:56
 */
public class AlgorithmUtil {
    /**
     * 获取二叉树的最大深度算法——层次遍历
     *
     * @param root
     * @return
     */
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        int len;
        while (true) {
            //获取当前层的节点数
            len = queue.size();
            if (len == 0)//当所有node都出队了，就认为没有新的子叶入队，遍历结束
                break;
            height++;
            while (len > 0) {//当前层节点遍历结束标志 len==0
                //每次出队，当前剩余节点数-1
                TreeNode node = queue.poll();
                len--;
                //当前节点有子叶，就添加到队列里(属于下层队列中节点)
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return height;
    }

    /**
     * 获取二叉树最大深度算法——递归遍历
     *
     * @param root
     * @return
     */
    public static int getHeight1(TreeNode root) {
        if (root == null) return 0;
        int leftHeight;
        int rightHeight;
        leftHeight = getHeight1(root.left);
        rightHeight = getHeight1(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 二叉树最大（小）宽度算法——层次遍历
     *
     * @param treeNode
     * @return
     */
    public static int getMaxWidth(TreeNode treeNode) {
        if (treeNode == null)
            return 0;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        int maxWidth = 1; // 最大宽度
        queue.add(treeNode); // 入队

        while (true) {
            int len = queue.size(); // 当前层的节点个数
            if (len == 0)
                break;
            while (len > 0) {// 如果当前层，还有节点
                TreeNode node = queue.poll();
                len--;
                if (node.left != null)
                    queue.add(node.left); // 下一层节点入队
                if (node.right != null)
                    queue.add(node.right);// 下一层节点入队
            }
            maxWidth = Math.max(maxWidth, queue.size());//本层节点数与下层节点数比较，取最大值
            //minWidth = Math.min(minWidth, queue.size());//取最小值
        }
        return maxWidth;
    }

    /**
     * 以left对应的数值为临界点切分数组为两部分
     *
     * @param array
     * @param left 子数组左边界下标
     * @param right 子数组右边界下标
     * @return
     */
    public static int partition(int[] array, int left, int right) {
        int key = array[left];
        while (left < right) {//左右逼近
            while (array[right] >= key && right > left) {
                right--;
            }
            array[left] = array[right];
            while (array[left] <= key && right > left) {
                left++;
            }
            array[right] = array[left];
        }
        array[right] = key;
        return right;
    }

    /**
     * 快速排序
     *
     * @param array
     * @param lo
     * @param hi
     */
    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }

    public static void main(String[] args) {
//        int[] array = new int[]{1, 4, 5, 2, 11, 3, 9, 2, 7, 20};
//        sort(array, 0, array.length - 1);
//        for (int a : array) {
//            System.out.println(a);
//        }
        collectData("/Users/chansiqing/eclipse-workspace/HellowWorld/src/xxxx.txt");
    }

    /**
     * 拿到一个二叉树
     *
     * @return
     */
    private static TreeNode generateNode() {
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(3);
        TreeNode tree4 = new TreeNode(4);
        TreeNode tree5 = new TreeNode(5);
        TreeNode tree6 = new TreeNode(6);
        TreeNode tree7 = new TreeNode(7);
        TreeNode tree8 = new TreeNode(8);
        tree1.left = tree2;
        tree1.right = tree3;
        tree2.left = tree4;
        tree3.left = tree5;
        tree5.left = tree6;
        tree6.left = tree7;
        tree6.right = tree8;
        return tree1;
    }

    public static ArrayList<ArrayList<String>> collectData(String fileName) {
        File file = new File(fileName);
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        ArrayList<String> title = new ArrayList<String>();
        FileReader fr;
        ArrayList<String> data = null;
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                String time = str.substring(str.indexOf(titleEndFlag) + titleEndFlag.length()).trim();
                if (str.contains(startFlag)) {
                    data = new ArrayList<String>();
                }
                if (data == null) return list;
                data.add(time);
                if (list.isEmpty()) {
                    title.add(str.substring(str.lastIndexOf(titleStartFlag) + 1, str.indexOf(titleEndFlag) - 1));
                }
                if (str.contains(endFlag)) {
                    if (list.isEmpty()) {
                        list.add(title);
                    }
                    list.add(data);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static String startFlag = "oneTimeStart";
    private static String endFlag = "oneTimeEnd";
    private static String titleEndFlag = "--->";
    private static String titleStartFlag = ":";

}
