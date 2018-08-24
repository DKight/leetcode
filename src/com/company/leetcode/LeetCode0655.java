package com.company.leetcode;


import com.company.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0655 {
    @Test
    public void test(){
        printTree(new TreeNode(1));
    }
    public List<List<String>> printTree(TreeNode root) {
        int depth = findDepth(root);
        List<List<String>> result = new ArrayList<>(depth);
        for (int i = 0; i < depth; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < ((int) Math.pow(2, depth))-1; j++) {
                temp.add("");
            }
            result.add(temp);
        }
        recursive(root,0,(int) Math.pow(2, depth)-1,0,result);
        return result;
    }
    public int findDepth(TreeNode root){
        if(root==null) {
            return 0;
        }
        return Math.max(findDepth(root.left),findDepth(root.right))+1;
    }
    public void recursive(TreeNode root,int low,int high,int depth,List<List<String>> result){
        if(root==null) {
            return;
        }
        int mid = (low+high)/2;
        result.get(depth).add(mid,String.valueOf(root.val));
        result.get(depth).remove(mid+1);
        recursive(root.left,low,mid-1,depth+1,result);
        recursive(root.right,mid+1,high,depth+1,result);
    }
}
