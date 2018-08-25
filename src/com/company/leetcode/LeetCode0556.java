package com.company.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode0556 {
    @Test
    public void test(){
        System.out.println(nextGreaterElement(1999999999));
    }
    //TODO
    public int nextGreaterElement(int n) {
        char[] charArray = String.valueOf(n).toCharArray();
        boolean flag =false;
        int pos = -1;
        for (int i = 0; i < charArray.length-1; i++) {
            if(charArray[i]<charArray[i+1]){
                flag = true;
                pos=i;
            }
        }
        if(!flag){
            return -1;
        }
        int min=pos+1;
        for(int j=pos+1;j<charArray.length;j++){
            if(charArray[j]>charArray[pos]&&charArray[min]>charArray[j]){
                min=j;
            }
        }
        char temp = charArray[min];
        charArray[min]=charArray[pos];
        charArray[pos]=temp;
        Arrays.sort(charArray,pos+1,charArray.length);
        return Long.valueOf(new String(charArray))>Integer.MAX_VALUE?-1:Integer.valueOf(new String(charArray));
    }
}
