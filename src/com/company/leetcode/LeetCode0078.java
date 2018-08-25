package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recusive(result,nums,0,new ArrayList<>());
        return result;
    }
    public void recusive(List<List<Integer>> result ,int[] nums,int low,List<Integer> path){
        if(low==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        recusive(result, nums, low+1, path);
        path.add(nums[low]);
        recusive(result, nums, low+1, path);
        path.remove(path.size()-1);
    }
}
