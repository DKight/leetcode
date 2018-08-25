package com.company.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode0547 {
    @Test
    public void test(){
        int[][] temp = new int[][]{
                new int[]{1,0,0,1},
                new int[]{0,1,1,0},
                new int[]{0,1,1,1},
                new int[]{1,0,1,1}
        };
        System.out.println(findCircleNum(temp));
    }
    @Deprecated
    public int findCircleNumDeprecated(int[][] M) {
        Set<Integer> set = new HashSet<>();
        int count =0 ;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if(M[i][j]==1&&i!=j){
                    for(int k=0;k<M.length;k++){
                        if(M[k][j]==1||M[k][i]==1){
                            M[k][i]=1;
                            M[k][j]=1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < M.length; i++) {
            if(!set.contains(i)) {
                count++;
                for (int j = 0; j < M[i].length; j++) {
                    if (M[i][j] == 1) {
                        set.add(j);
                    }
                }
            }
        }
        return count;
    }
    public int findCircleNum(int[][] M) {
        int[] result = new int[M.length];
        Queue<Integer> queue = new LinkedList<>();
        int count=0;
        for (int i = 0; i < result.length; i++) {
            if(result[i]==0){
                count++;
                queue.offer(i);
                while(!queue.isEmpty()){
                    int j=queue.poll();
                    for (int k = 0; k < M[j].length; k++) {
                        if(j!=k&&result[k]!=1&&M[j][k]==1){
                            queue.offer(k);
                            result[k]=1;
                        }
                    }
                }
            }
        }
        return count;
    }

}
