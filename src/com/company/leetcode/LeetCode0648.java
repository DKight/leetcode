package com.company.leetcode;

import com.company.DictTreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0648 {
    @Test
    public void test(){
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        replaceWords(dict,"the cattle was rattled by the battery");
    }
    public String replaceWords(List<String> dict, String sentence) {
        DictTreeNode dictTreeNode = new DictTreeNode();
        for (String s : dict) {
            dictTreeNode.add(s);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : sentence.split(" ")) {
            if(s.equals(" ")){
                stringBuilder.append(" ");
                continue;
            }
            stringBuilder.append(dictTreeNode.shortestString(s)).append(" ");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }

}
