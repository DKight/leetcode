package com.company.leetcode;

import org.junit.Test;

public class LeetCode0860 {
    @Test
    public void test(){
        lemonadeChange(new int[]{5,5,5,10,5,5,10,20,20,20});
    }
    public boolean lemonadeChange(int[] bills) {
        int[] charges = new int[2];
        for (int bill : bills) {
            int charge = bill-5;
            while(charge>0){
                if(charge-10>=0){
                    if(charges[1]!=0){
                        charge-=10;
                        charges[1]--;
                    }
                }
                if(charge-5>=0){
                    if(charges[0]<charge/5){
                        return false;
                    }
                    charge=0;
                    charges[0]-=charge/5;
                }

            }
            if(bill<20){
                charges[bill/5-1]++;
            }
        }
        return true;
    }
}
