/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * 2 --> 4 --> 3
 * 5 --> 6 --> 4
 * -----------------
 * 7 --> 0 --> 8
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
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

public class add_Two_Number {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int carry = 0;
        ListNode trav = result;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            trav.next = new ListNode(sum);
            trav = trav.next;
            l1 = l1.next; l2 = l2.next;
        }

        while(l1 == null && l2 != null){
            int sum = l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            trav.next = new ListNode(sum);
            trav = trav.next;
            l2 = l2.next;
        }

        while(l2 == null && l1 != null){
            int sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            trav.next = new ListNode(sum);
            trav = trav.next;
            l1 = l1.next;
        }

        if(carry != 0){
            trav.next = new ListNode(carry);
        }

        return  result.next;
    }
}
