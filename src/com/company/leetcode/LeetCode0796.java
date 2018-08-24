package com.company.leetcode;

public class LeetCode0796 {
    public boolean rotateString(String A, String B) {
        if(A==null&&B!=null){
            return false;
        }
        if(A==null){
            return true;
        }
        if(A.equals(B)){
            return true;
        }
        if(A.length()==B.length()&&(A+A).contains(B)){
            return true;
        }else{
            return false;
        }
    }
}
