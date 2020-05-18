package com.example.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public interface EasyProblems {
    static String toString(StringBuilder sb) {
        sb.insert(0, "[");
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    static void breathFirstOrder(EasyProblemsImp.TreeNode root, StringBuilder sb){
        Queue<EasyProblemsImp.TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        EasyProblemsImp.TreeNode node;
        while(!queue.isEmpty()){
            node = queue.poll();
            sb.append(node.val).append(",");
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }

    static void depthFirstOrder(EasyProblemsImp.TreeNode root, StringBuilder sb){
        Stack<EasyProblemsImp.TreeNode> stack = new Stack<>();
        stack.push(root);
        EasyProblemsImp.TreeNode node;
        while(!stack.isEmpty()){
            node = stack.pop();
            sb.append(node.val).append(",");
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left !=null){
                stack.push(node.left);
            }
        }
    }

    static void preorder(EasyProblemsImp.TreeNode root, StringBuilder sb) {
        boolean noChildren = root.left == null && root.right == null;
        sb.append(root.val).append(',');
        if (root.left != null) {
            preorder(root.left, sb);
        } else if(!noChildren){
            sb.append("NULL,");
        }
        if (root.right != null) {
            preorder(root.right, sb);
        } else if(!noChildren){
            sb.append("NULL,");
        }
    }

    static void inorder(EasyProblemsImp.TreeNode root, StringBuilder sb) {
        boolean noChildren = root.left == null && root.right == null;
        if (root.left != null) {
            inorder(root.left, sb);
        }else if(!noChildren){
            sb.append("NULL,");
        }
        sb.append(root.val).append(',');
        if (root.right != null) {
            inorder(root.right, sb);
        }else if(!noChildren){
            sb.append("NULL,");
        }
    }

    static void postorder(EasyProblemsImp.TreeNode root, StringBuilder sb) {
        boolean noChildren = root.left == null && root.right == null;
        if (root.left != null) {
            postorder(root.left, sb);
        }else if(!noChildren){
            sb.append("NULL,");
        }
        if (root.right != null) {
            postorder(root.right, sb);
        } else if(!noChildren){
            sb.append("NULL,");
        }
        sb.append(root.val).append(",");
    }

    List<List<Integer>> levelOrder(EasyProblemsImp.TreeNode root);

    // 1. 两数之和
    int[] twoSum(int[] nums, int target);

    // 7. 整数反转
    int reverse(int x);

    // 9. 回文数
    boolean isPalindrome(int x);

    // 13
    int romanToInt(String s);

    // 14
    String longestCommonPrefix(String[] strs);

    // 189
    void rotate(int[] nums, int k);

    int singleNumber(int[] nums);

    int majorityElement(int[] nums);

    void merge(int[] nums1, int m, int[] nums2, int n);

    // 100
    boolean isSameTree(EasyProblemsImp.TreeNode p, EasyProblemsImp.TreeNode q);

    //
    int maxDepth(EasyProblemsImp.TreeNode root);

    boolean isBalanced(EasyProblemsImp.TreeNode root);

    int minDepth(EasyProblemsImp.TreeNode root);

    // 108
    EasyProblemsImp.TreeNode sortedArrayToBST(int[] nums);

    // 107
    List<List<Integer>> levelOrderBottom(EasyProblemsImp.TreeNode root);

    // 704
    int search(int[] nums, int target);

    // 25
    EasyProblemsImp.ListNode reverseKGroup(EasyProblemsImp.ListNode head, int k);
}
