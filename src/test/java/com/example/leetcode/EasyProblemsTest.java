package com.example.leetcode;

import org.junit.Assert;
import org.junit.Test;


public class EasyProblemsTest {
    private EasyProblems agent = (EasyProblems) ProblemAgent.agent(EasyProblems.class, new EasyProblemsImp());

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
}
