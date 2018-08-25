package com.company.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0022 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recursive(n,n,new StringBuilder(),result);
        return result;
    }
    public void recursive(int leftN,int rightN,StringBuilder stringBuilder,List<String> result){
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < stringBuilder.length(); i++) {
            if(stringBuilder.charAt(i)=='('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    return;
                }else{
                    if(stack.peek()==')'){
                        return;
                    }else{
                        stack.pop();
                    }
                }
            }
        }
        if(leftN==0&&rightN==0){
            result.add(stringBuilder.toString());
            return;
        }
        if(leftN>0){
            StringBuilder temp = new StringBuilder(stringBuilder).append("(");
            recursive(leftN-1, rightN, temp, result);
        }
        if(rightN>0){
            StringBuilder temp = new StringBuilder(stringBuilder).append(")");
            recursive(leftN, rightN-1, temp, result);
        }
    }
}
