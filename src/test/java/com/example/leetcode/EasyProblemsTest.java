package com.example.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


public class EasyProblemsTest {
    private EasyProblems agent = (EasyProblems) ProblemAgent.agent(EasyProblems.class, new EasyProblemsImp());
    private IMinStack stackAgent = (IMinStack) ProblemAgent.agent(IMinStack.class, new MinStack());

    private EasyProblemsImp.TreeNode testData(){
        EasyProblemsImp.TreeNode root = new EasyProblemsImp.TreeNode(1);
        EasyProblemsImp.TreeNode node2 = new EasyProblemsImp.TreeNode(2);
        EasyProblemsImp.TreeNode node3 = new EasyProblemsImp.TreeNode(3);
        EasyProblemsImp.TreeNode node4 = new EasyProblemsImp.TreeNode(4);
        EasyProblemsImp.TreeNode node5 = new EasyProblemsImp.TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        return root;
    }

    private EasyProblemsImp.ListNode testLinkedListData(){
        EasyProblemsImp.ListNode head = new EasyProblemsImp.ListNode(1);
        EasyProblemsImp.ListNode current = head;
        current.next = new EasyProblemsImp.ListNode(2);
        current = current.next;
        current.next = new EasyProblemsImp.ListNode(3);
        current = current.next;
        current.next = new EasyProblemsImp.ListNode(4);
        current = current.next;
        current.next = new EasyProblemsImp.ListNode(5);
        return head;
    }

    private void out(EasyProblemsImp.ListNode head){
        if(head== null){
            System.out.println("empty linked list.");
            return;
        }
        EasyProblemsImp.ListNode current = head;
        do{
            System.out.print(current.val+"-->");
            current = current.next;
        }while(current != null);
        System.out.println();
    }

    @Test
    public void reverseKGroupTest(){
        EasyProblemsImp.ListNode head = testLinkedListData();
        out(head);
        EasyProblemsImp.ListNode reversed = agent.reverseKGroup(head, 2);
        out(reversed);
    }

    @Test
    public void levelOrderTest(){
        EasyProblemsImp.TreeNode root = testData();
        List<List<Integer>> result = agent.levelOrder(root);
        StringBuilder sb = new StringBuilder();
        for(List<Integer> level: result){
            sb.delete(0, sb.length());
            sb.append("[");
            for(Integer i : level){
                sb.append(i).append(",");
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }

    @Test
    public void levelOrderBottomTest(){
        EasyProblemsImp.TreeNode root = testData();
        String s = agent.levelOrderBottom(root).toString();
        System.out.println(s);
    }

    @Test
    public void sortedArrayToBSTTest(){
        int[] nums = new int[]{-10,-3,0,5,9};
        EasyProblemsImp.TreeNode root = agent.sortedArrayToBST(nums);
    }

    @Test
    public void minDepthTest(){
        EasyProblemsImp.TreeNode root = testData();
        Assert.assertEquals(2, agent.minDepth(root));
    }

    @Test
    public void isBalancedTest(){
        EasyProblemsImp.TreeNode root = testData();
        Assert.assertTrue(agent.isBalanced(root));
    }

    @Test
    public void maxDepthTest(){
        EasyProblemsImp.TreeNode root = testData();
        int depth = agent.maxDepth(root);
        Assert.assertEquals(2, depth);
    }

    @Test
    public void singleNumber(){
        int[] nums = {4,1,2,1,2};
        int result = agent.singleNumber(nums);
        Assert.assertEquals(4, result);
    }

    @Test
    public void majorityElement(){
        int[] nums = {2,2,1,1,1,2,2};
        int result = agent.majorityElement(nums);
        Assert.assertEquals(2, result);
    }

    @Test
    public void reverse(){
        int result = agent.reverse(Integer.MAX_VALUE);
        Assert.assertEquals(0, result);
    }

    @Test
    public void romanToInt(){
        int result = agent.romanToInt("MCMXCIV");
        Assert.assertEquals(1994, result);
    }

    @Test
    public void longestCommonPrefixTest(){
        String result = agent.longestCommonPrefix(new String[]{"flj","flow","flight",""});
        Assert.assertEquals("", result);
    }

    @Test
    public void rotateTest(){
        int[] nums = new int[]{1,2};
        agent.rotate(nums, 1);
        Assert.assertArrayEquals(new int[]{2,1}, nums);
    }

    @Test
    public void minStackTest(){
        stackAgent.push(1);
        stackAgent.push(10);
        Assert.assertEquals(1, stackAgent.getMin()); ;
        stackAgent.push(-2);
        stackAgent.push(-1);
        Assert.assertEquals(-2, stackAgent.getMin()); ;
        stackAgent.pop();
        stackAgent.pop();
        stackAgent.push(1);
        stackAgent.pop();
        Assert.assertEquals(1, stackAgent.getMin()); ;
    }

    @Test
    public void toStringTest(){
        List<InfiniteRecursion> list = new ArrayList<>(10);
        for (int i = 0; i< 10; i++){
            list.add(new InfiniteRecursion());
        }
        System.out.println(list);
    }

    static class InfiniteRecursion{
        @Override
        public String toString(){
            return "InfiniteRecursion address: "+super.toString()+"\n";
        }
    }
}
