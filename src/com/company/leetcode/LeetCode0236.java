package com.company.leetcode;

import com.company.TreeNode;
import org.junit.Test;

public class LeetCode0236 {
    @Test
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(p==root||q==root){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right= lowestCommonAncestor(root.right,p,q);
        return left!=null&&right!=null?root:left==null?right:left;
    }

}
