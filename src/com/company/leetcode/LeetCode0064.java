package com.company.leetcode;

import org.junit.Test;

public class LeetCode0064 {
    @Test
    public void test(){
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < dp.length; i++) {
            int[] temp = dp[i];
            for (int j = 0; j < temp.length; j++) {
                if(i==0&&j==0){
                    continue;
                }
                int tempValue = Integer.MAX_VALUE;
                if(i!=0){
                    tempValue=dp[i-1][j];
                }
                if(j!=0){
                    tempValue=Math.min(dp[i][j-1],tempValue);
                }
                dp[i][j]=tempValue+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
