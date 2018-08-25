package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursive(nums,0,result);
        return result;
    }
    public void recursive(int[] nums,int low,List<List<Integer>> result){
        if(low==nums.length-1){
            List<Integer> temp = new ArrayList<>(nums.length);
            for (int num : nums) {
                temp.add(num);
            }
            result.add(temp);
            return;
        }
        for (int i = low; i < nums.length; i++) {
            swap(nums,low,i);
            recursive(nums, low+1, result);
            swap(nums,low,i);
        }
    }
    public void swap(int[] nums,int low,int high){
        int temp = nums[low];
        nums[low]=nums[high];
        nums[high]=temp;
    }
}
