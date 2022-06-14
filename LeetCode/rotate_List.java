/**
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 * 
 * 
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
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

public class rotate_List {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0)
            return head;
        if (head == null || head.next == null)
            return head;
        ListNode trav = head;
        int size = 0;
        while (trav.next != null) {
            trav = trav.next;
            size++;
        }
        size++;
        trav.next = head;
        k = k % size;
        k = size - k;
        trav = head.next;
        while (k > 1) {
            trav = trav.next;
            head = head.next;
            k--;
        }
        head.next = null;
        return trav;
    }
}