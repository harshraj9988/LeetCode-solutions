
/**
 * You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
 */

class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

public class reorder_List{

    private ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode trav1 = null;
        ListNode trav2 = head.next;
        while (trav2 != null) {
            head.next = trav1;
            trav1 = head;
            head = trav2;
            trav2 = trav2.next;
        }
        head.next = trav1;
        return head;
    }


    public void reorderList(ListNode head) {
        
        if(head.next == null || head.next.next == null) return;

        ListNode trav1 = head;
        ListNode trav2 = head.next;

        while(trav2 != null && trav2.next != null){
            trav1 = trav1.next;
            trav2 = trav2.next.next;
        }

        ListNode rev = reverseList(trav1.next);

        trav1.next = null;

        ListNode node = head;

        while(rev != null){

            ListNode temp = node.next;

            node.next = rev;
            rev = rev.next;

            node.next.next = temp;
            node = temp;

        }

    }
}