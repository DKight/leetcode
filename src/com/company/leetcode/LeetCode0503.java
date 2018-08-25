package com.company.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode0503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i]=-1;
        }
        int n=2;
        while(n>0){
            for (int i = 0; i < nums.length; i++) {
                while(!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                    result[stack.pop()]=nums[i];
                }
                stack.push(i);
            }
            n--;
        }
        return result;
    }
}
