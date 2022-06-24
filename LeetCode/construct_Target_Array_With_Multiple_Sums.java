/**
 * You are given an array target of n integers. From a starting array arr consisting of n 1's, you may perform the following procedure :

let x be the sum of all elements currently in your array.
choose index i, such that 0 <= i < n and set the value of arr at index i to x.
You may repeat this procedure as many times as needed.
Return true if it is possible to construct the target array from arr, otherwise, return false.

 

Example 1:

Input: target = [9,3,5]
Output: true
Explanation: Start with arr = [1, 1, 1] 
[1, 1, 1], sum = 3 choose index 1
[1, 3, 1], sum = 5 choose index 2
[1, 3, 5], sum = 9 choose index 0
[9, 3, 5] Done
Example 2:

Input: target = [1,1,1,2]
Output: false
Explanation: Impossible to create target array from [1,1,1,1].
Example 3:

Input: target = [8,5]
Output: true
 

Constraints:

n == target.length
1 <= n <= 5 * 104
1 <= target[i] <= 109
 */
import java.util.*;;
public class construct_Target_Array_With_Multiple_Sums {
    private int sum = 0;
    
    public boolean isPossible(int[] target) {
        
        if(target.length==1 && target[0]!=1) return false;
        
        PriorityQueue<Integer> heap = addToPriorityQueue(target);
        
        while(heap.peek()>1 ){
            
            int num = heap.poll();
            int newNum=0;
            if((sum-num)==1) newNum =  1 ;
            else if(sum - num>1) newNum = num % (sum - num);
            else return false;
            if(num<=newNum) return false;
            if(newNum == 0) return false;
            sum = sum - num + newNum;
            heap.add(newNum); 
            
        }
        
        return heap.peek()==1;
    }
    
    
    private PriorityQueue<Integer> addToPriorityQueue(int[] target){
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int tar: target){
            heap.add(tar);
            sum+=tar;
        }
        return heap;
    }
}
