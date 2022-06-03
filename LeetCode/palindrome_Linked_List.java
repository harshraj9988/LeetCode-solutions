import java.util.List;
import java.util.Stack;

/**
    Given the head of a singly linked list, return true if it is a palindrome.

    

    Example 1:

        1 --> 2 --> 2 --> 1

    Input: head = [1,2,2,1]
    Output: true

    Example 2:

        1 --> 2

    Input: head = [1,2]
    Output: false
    

    Constraints:

    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9
    

    Follow up: Could you do it in O(n) time and O(1) space?
    Accepted
    985,254
    Submissions
    2,100,307
 */

 
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class palindrome_Linked_List {


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


    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        ListNode slow= head, fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = head;

        ListNode rev = reverseList(slow.next);

        while(rev != null){
            if(curr.val != rev.val) return false;
            curr = curr.next;
            rev = rev.next;
        }
        
        return true;
    }
}
