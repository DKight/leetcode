package com.company.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0638 {
    @Test
    public void test(){
       List<Integer> price = new ArrayList<>();
       price.add(2);
       price.add(5);
       List<List<Integer>> specials = new ArrayList<>();
       List<Integer> special1 = new ArrayList<>();
       special1.add(3);
       special1.add(0);
       special1.add(5);
       List<Integer> special2 = new ArrayList<>();
       special2.add(1);
       special2.add(2);
       special2.add(10);
       specials.add(special1);
       specials.add(special2);
       List<Integer> needs = new ArrayList<>();
       needs.add(3);
       needs.add(2);
        System.out.println(shoppingOffers(price,specials,needs));
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        boolean flag = true;
        for (int i = 0; i < needs.size(); i++) {
            if(needs.get(i)!=0){
                flag=false;
            }
        }
        if(flag){
            return 0;
        }
        int min =Integer.MAX_VALUE;
        specialLoop:for (List<Integer> list : special) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < needs.size(); i++) {
                if(list.get(i)>needs.get(i)){
                    continue specialLoop;
                }
                temp.add(needs.get(i)-list.get(i));
            }
            min=Math.min(min,shoppingOffers(price,special,temp)+list.get(needs.size()));
        }
        for (int i = 0; i < price.size(); i++) {
            if(needs.get(i)==0){
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < needs.size(); j++) {
                if(i==j){
                    temp.add(0);
                }
                else {
                    temp.add(needs.get(j));
                }
            }
            min=Math.min(min,shoppingOffers(price, special,temp)+needs.get(i)*price.get(i));
        }
        return min;
    }
}
