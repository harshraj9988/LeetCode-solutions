/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate
 * numbers, leaving only distinct numbers from the original list. Return the
 * linked list sorted as well.
 * 
 * 
 * 
 * Example 1:
 * 
 * 1 --> 2 --> 3 --> 3 --> 4 --> 5
 * -------------------------------
 * 1 --> 2 --> 5
 * 
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 * 
 * 
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
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

public class remove_Duplicates_From_Sorted_List_2 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = new ListNode();
        node.next = head;

        ListNode trav1 = node;
        ListNode trav2 = head;

        while (trav2 != null) {

            while (trav2.next != null && trav2.val == trav2.next.val) {
                trav2 = trav2.next;
            }

            if (trav1.next != trav2) {
                trav1.next = trav2.next;
                trav2 = trav2.next;
            } else {
                trav1 = trav1.next;
                trav2 = trav2.next;
            }
        }

        return node.next;
    }
}
