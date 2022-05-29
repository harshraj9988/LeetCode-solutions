    // Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

    

    // Example 1:


    // Input: head = [1,1,2]
    // Output: [1,2]
    // Example 2:


    // Input: head = [1,1,2,3,3]
    // Output: [1,2,3]
    

    // Constraints:

    // The number of nodes in the list is in the range [0, 300].
    // -100 <= Node.val <= 100
    // The list is guaranteed to be sorted in ascending order.



 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */   

public class remove_Duplicates_From_Sorted_List {

    public class ListNode {                                                                 // ListNode is predefined in the question itself.
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {                                           
        if(head==null) return head;
        if(head.next==null) return head;
        if(head.val==head.next.val && head.next.next==null){ head.next=head.next.next; return head;}
        
        ListNode trav1=head;
        ListNode trav2=head.next;
        while (trav2!=null){
            if(trav1.val==trav2.val){
                trav1.next=trav2.next;
                trav2=trav2.next;
            }
            else{
                trav1=trav1.next;
                trav2=trav2.next;
            }
        }
        return head;
    }
}
