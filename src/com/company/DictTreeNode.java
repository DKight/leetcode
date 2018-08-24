package com.company;

import java.util.HashMap;
import java.util.Map;

public class DictTreeNode {
    public Map<Character,DictTreeNode> treeNodeMap = new HashMap<>();
    public Character val;
    public boolean isEnd=false;

    public DictTreeNode() {
    }

    public DictTreeNode(Character val) {
        this.val = val;
    }

    public void add(String s){
        Map<Character,DictTreeNode> tempMap = treeNodeMap;
        DictTreeNode dictTreeNode=this;
        for (int i = 0; i < s.length(); i++) {
            if(!tempMap.containsKey(s.charAt(i))){
                tempMap.put(s.charAt(i),new DictTreeNode(s.charAt(i)));
            }
            dictTreeNode=tempMap.get(s.charAt(i));
            tempMap = dictTreeNode.treeNodeMap;
        }
        dictTreeNode.isEnd=true;
    }
    public String shortestString(String s){
        Map<Character,DictTreeNode> tempMap = treeNodeMap;
        DictTreeNode dictTreeNode=this;
        for (int i = 0; i < s.length(); i++) {
            if(tempMap.get(s.charAt(i))==null){
                return s;
            }
            dictTreeNode=tempMap.get(s.charAt(i));
            tempMap=dictTreeNode.treeNodeMap;
            if(dictTreeNode.isEnd){
                return s.substring(0,i+1);
            }
        }
        return s;
    }
}
