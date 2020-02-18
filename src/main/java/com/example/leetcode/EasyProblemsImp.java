package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class EasyProblemsImp implements EasyProblems {

    @Override
    public int[] twoSum(int[] nums, int target) {
        int diff;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (diff == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x = x / 10;
        }

        return x == y || y / 10 == x;
    }

    @Override
    public int reverse(int x) {
        try {
            boolean negative = false;
            if (x < 0) {
                negative = true;
                x = -x;
            }
            String from = String.valueOf(x);
            StringBuilder sb = new StringBuilder(from);
            int result = Integer.parseInt(sb.reverse().toString());
            if (negative) {
                result = -result;
            }
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int romanToInt(String s) {
        Map<String, Integer> table = new HashMap<String, Integer>(32) {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }};

        int len = s.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            char current = s.charAt(i);
            if (i + 1 < len && (current == 'I' || current == 'X' || current == 'C')) {
                char next = s.charAt(i + 1);
                boolean fourOrNine = current == 'I' && (next == 'V' || next == 'X');
                boolean fortyOrNinety = current == 'X' && (next == 'L' || next == 'C');
                boolean fourHundredOrNineHundred = current == 'C' && (next == 'D' || next == 'M');
                if (fourOrNine || fortyOrNinety || fourHundredOrNineHundred) {
                    sum += table.get(String.valueOf(new char[]{current, next}));
                    i++;
                    continue;
                }
            }
            sum += table.get(String.valueOf(current));
        }
        return sum;
    }

    @Override
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int middle = (left + right) / 2;
        String l = longestCommonPrefix(strs, left, middle);
        String r = longestCommonPrefix(strs, middle + 1, right);
        return commonPrefix(l, r);
    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    @Override
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        for (int count = 0, i = 0, j, temp; count < nums.length; i++) {
            j = i;
            do {
                int next = (j + k) % nums.length;
                temp = nums[i];
                nums[i] = nums[next];
                nums[next] = temp;
                j = next;
                count++;
            } while (i != j);
        }

    }

    @Override
    public int singleNumber(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int singleOne = 0;
        for (int num : nums) {
            singleOne ^= num;
        }

        return singleOne;
    }

    @Override
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p] = nums2[p2];
                p2--;
            } else {
                nums1[p] = nums1[p1];
                p1--;
            }
            p--;
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    @Override
    public int majorityElement(int[] nums) {
        // 1
//        int len = nums.length;
//        int threshold = len/2;
//        int n = 0;
//        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>(len);
//        for (int num : nums) {
//            if(table.containsKey(num)){
//                table.put(num, table.get(num)+1);
//            }else{
//                table.put(num, 1);
//            }
//        }
//
//        for(Map.Entry<Integer, Integer> entry : table.entrySet()){
//            if(entry.getValue()>threshold){
//                n = entry.getKey();
//                break;
//            }
//        }
//        return n;
//
        // 2
//        Arrays.sort(nums);
//        return nums[nums.length/2];

        // 3
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    @Override
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    @Override
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeftTreeDepth = maxDepth(root.left);
        int maxRightTreeDepth = maxDepth(root.right);

        return Math.max(maxLeftTreeDepth, maxRightTreeDepth) + 1;
    }

    @Override
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(root.left != null){
            left = minDepth(root.left);
        }
        if(root.right != null){
            right = minDepth(root.right);
        }

        return Math.min(left, right) + 1;
    }

    @Override
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }

        boolean isLeftTreeBalanced = isBalanced(root.left);
        boolean isRightTreeBalanced = isBalanced(root.right);

        return isLeftTreeBalanced && isRightTreeBalanced;
    }

    int[] nums;
    @Override
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return createTreeNode(0, this.nums.length-1);
    }

    private TreeNode createTreeNode(int left, int right){
        if(left > right){
            return null;
        }

        int p = (left + right) / 2;

        TreeNode root = new TreeNode(nums[p]);
        root.left = createTreeNode(left, p-1);
        root.right = createTreeNode(p+1, right);

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
