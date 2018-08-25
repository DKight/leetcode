package com.company.leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode0496 {
    @Test
    public void test(){
        nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums2) {
            while(!stack.isEmpty()&&stack.peek()<num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i]= map.getOrDefault(nums1[i],-1);
        }
        return result;
    }
}
