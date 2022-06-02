
/**
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 1 --> 2 --> 3 --> 4 --> 5
 * ----------------------------
 * 5 --> 4 --> 3 --> 2 --> 1
 * 
 * 
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 * 
 * 
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 * 
 * Input: head = []
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
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

public class reverse_Linked_List {
    // iterative method
    public ListNode reverseListIterative(ListNode head) {
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

    // recursive method
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode after = head.next;
        head.next = null;
        ListNode curr = reverseListRecursive(after);
        after.next = head;

        return curr;
    }

    public ListNode reverseList(ListNode head) {
        return reverseListIterative(head);
        // return reverseListRecursive(head);
    }
}