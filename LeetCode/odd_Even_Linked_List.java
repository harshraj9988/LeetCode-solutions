
/**

*/

import java.util.*;
import java.io.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            ++len;
        }
        if (len == 2)
            return head;
        ListNode prev = head;
        ListNode curr = head.next;
        int ind = 2;
        while (ind <= len) {
            if (ind % 2 == 0) {
                prev.next = curr.next;
                curr.next = null;
                tail.next = curr;
                tail = tail.next;
                curr = prev.next;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
            ++ind;
        }
        
        return head;
    }
}