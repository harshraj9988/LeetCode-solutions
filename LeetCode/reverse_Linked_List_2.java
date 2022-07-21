/**
 * Given the head of a singly linked list and two integers left and right where
 * left <= right, reverse the nodes of the list from position left to position
 * right, and return the reversed list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 * 
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * 
 */

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

public class reverse_Linked_List_2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head.next == null)
            return head;

        ListNode newHead = new ListNode(0, head);
        
        ListNode trav1 = newHead;
        ListNode trav2 = newHead.next;

        ListNode start = new ListNode(), startPrev = new ListNode();

        while(right>0){
            if(left==1){
                startPrev = trav1;
                start = trav2;
            }

            trav1 = trav1.next;
            trav2 = trav2.next;


            right--;
            left--;
        }

        trav1.next = null;

        ListNode revEnd = start;

        startPrev.next = reverseListIterative(start);
        revEnd.next = trav2;

        return newHead.next;
    }

    private ListNode reverseListIterative(ListNode head) {
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
}
