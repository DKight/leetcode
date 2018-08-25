package com.company;

public class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) { val = x; }
      public ListNode add(int x){
          ListNode temp = new ListNode(x);
          this.next=temp;
          return temp;
      }

}
