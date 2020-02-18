package com.example.leetcode;

public interface EasyProblems {
    static String toString(EasyProblemsImp.TreeNode root) {
        if(root == null){
            return "NULL";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        inorder(root, sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    static void preorder(EasyProblemsImp.TreeNode root, StringBuilder sb) {
        sb.append(root.val).append(',');
        if (root.left != null) {
            preorder(root.left, sb);
        } else{
            sb.append("NULL,");
        }
        if (root.right != null) {
            preorder(root.right, sb);
        } else{
            sb.append("NULL,");
        }
    }

    static void inorder(EasyProblemsImp.TreeNode root, StringBuilder sb) {
        if (root.left != null) {
            inorder(root.left, sb);
        }else{
            sb.append("NULL,");
        }
        sb.append(root.val).append(',');
        if (root.right != null) {
            inorder(root.right, sb);
        }else{
            sb.append("NULL,");
        }
    }

    static void postorder(EasyProblemsImp.TreeNode root) {
        if (root.left != null) {
            postorder(root.left);
        }
        if (root.right != null) {
            postorder(root.right);
        }
        System.out.println(root.val);
    }

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
}
