package com.example.leetcode;

import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.misc.Unsafe;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode {

    public static void main(String[] args) {
        EasyProblemsImp.TreeNode root = testData();
        StringBuilder sb = new StringBuilder();
        EasyProblems.breathFirstOrder(root, sb);
        System.out.println("广度优先搜索: "+EasyProblems.toString(sb));

        sb.delete(0, sb.length());
        EasyProblems.depthFirstOrder(root, sb);
        System.out.println("深度优先(中序):"+EasyProblems.toString(sb));

        sb.delete(0, sb.length());
        EasyProblems.inorder(root, sb);
        System.out.println("深度优先(中序):"+EasyProblems.toString(sb));

        sb.delete(0, sb.length());
        EasyProblems.preorder(root, sb);
        System.out.println("深度优先(先序):"+EasyProblems.toString(sb));

        sb.delete(0, sb.length());
        EasyProblems.postorder(root, sb);
        System.out.println("深度优先(后序):"+EasyProblems.toString(sb));



    }

    private static EasyProblemsImp.TreeNode testData(){
        EasyProblemsImp.TreeNode root = new EasyProblemsImp.TreeNode(1);
        EasyProblemsImp.TreeNode node2 = new EasyProblemsImp.TreeNode(2);
        EasyProblemsImp.TreeNode node3 = new EasyProblemsImp.TreeNode(3);
        EasyProblemsImp.TreeNode node4 = new EasyProblemsImp.TreeNode(4);
        EasyProblemsImp.TreeNode node5 = new EasyProblemsImp.TreeNode(5);
        EasyProblemsImp.TreeNode node6 = new EasyProblemsImp.TreeNode(6);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        return root;
    }

    private static Unsafe getTheUnsafe(){
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe)field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
