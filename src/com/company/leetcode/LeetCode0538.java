package com.company.leetcode;

import com.company.TreeNode;

public class LeetCode0538 {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        recursive(root);
        return root;
    }
    public void recursive(TreeNode root){
        if(root==null){
            return ;
        }
        recursive(root.right);
        root.val+=sum;
        sum=root.val;
        recursive(root.left);
    }
}
