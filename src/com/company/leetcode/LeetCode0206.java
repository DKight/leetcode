package com.company.leetcode;

import com.company.ListNode;
import org.junit.Test;

public class LeetCode0206 {
    @Test
    public void test(){
        ListNode node = new ListNode(5);
        node.add(4).add(3).add(2).add(1);
        reverseList(node);
    }
    public ListNode reverseList(ListNode head) {
        ListNode root = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next=root;
            root=head;
            head=temp;
        }
        return root;
    }
}
