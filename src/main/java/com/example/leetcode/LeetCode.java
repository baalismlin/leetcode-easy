package com.example.leetcode;

import sun.management.resources.agent;

import java.util.Arrays;

public class LeetCode {

    public static void main(String[] args) {
        EasyProblemsImp.TreeNode p = new EasyProblemsImp.TreeNode(1);
        EasyProblemsImp.TreeNode a = new EasyProblemsImp.TreeNode(2);
        EasyProblemsImp.TreeNode b = new EasyProblemsImp.TreeNode(3);
        p.left = a;
        p.right = b;
        EasyProblemsImp.TreeNode q = new EasyProblemsImp.TreeNode(1);
        q.right = b;
        q.left = a;
        EasyProblems agent = new EasyProblemsImp();
        agent.isSameTree(p, q);
    }
}
