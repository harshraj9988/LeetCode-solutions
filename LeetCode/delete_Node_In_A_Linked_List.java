/**

*/

import java.util.*;
import java.io.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public void deleteNode(ListNode node) {
        if(node.next==null) { node = null; }
        ListNode temp = new ListNode(-1);
        while(node.next!=null) {
            node.val = node.next.val;
            temp = node;
            node = node.next;
        }
        temp.next = null;
    }
}