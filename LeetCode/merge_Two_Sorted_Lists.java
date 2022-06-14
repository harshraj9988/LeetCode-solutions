/**
 You are given the heads of two sorted linked lists list1 and list2.

 Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

 Return the head of the merged linked list.



 Example 1:

            1 --> 2 --> 4
            1 --> 3 --> 4
           ----------------
        1 --> 1 -->1 --> 2 --> 3 --> 4 --> 4

 Input: list1 = [1,2,4], list2 = [1,3,4]
 Output: [1,1,2,3,4,4]
 Example 2:

 Input: list1 = [], list2 = []
 Output: []
 Example 3:

 Input: list1 = [], list2 = [0]
 Output: [0]


 Constraints:

 The number of nodes in both lists is in the range [0, 50].
 -100 <= Node.val <= 100
 Both list1 and list2 are sorted in non-decreasing order.
 *
 */


    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }



public class merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = new ListNode();
        ListNode t2 = list1;
        t1.next = t2;
        ListNode f = t1;

        ListNode t3 = list2;
        ListNode t4 = list2;


        while(t2 != null && t4 != null){

            if(t2.val >= t3.val){
                t4 = t4.next;

                t1.next = t3;
                t3.next = t2;

                t1 = t1.next;
                t3 = t4;
            }else{
                t2 = t2.next;
                t1 = t1.next;
            }

        }

        if(t2 == null && t4 != null){
            t1.next = t4;
        }

        return f.next;
    }
}
