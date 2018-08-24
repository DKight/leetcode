package com.company.leetcode;

import org.junit.Test;

public class LeetCode0357 {
    @Test
    public void test(){
        System.out.println(countNumbersWithUniqueDigits(3));
    }
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n==1) return 10;
        int[] nums = new int[n+1];
        int result = 91 ;
        nums[1]=10;
        nums[2]=81;
        for (int i = 3; i < nums.length; i++) {
            nums[i]=nums[i-1]*(10-(i-1));
            result+=nums[i];
        }
        return result;
    }
}
