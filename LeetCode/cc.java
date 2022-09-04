import java.util.*;

public class cc {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int len = Integer.MIN_VALUE;
        int[] x = new int[n];
        
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if((nums[i]&nums[j])==0) x[i]++;
                else break;
            }
        }
        for(int i:x){
            len = Math.max(i, len);
        }

        if(len==0) return 1;
        
        int i=1;
        while(i<n){
            int temp = 1;
            while((x[i]-x[i-1])==1){
                temp++;
                i++;
            }
            len = Math.max(len, temp);
            i++;
        }

        return len;
    }



    public static void main(String[] args) {
        int[] nums = {338970160,525086042,19212931,213753017,321613307,553272419,190837185,548628106,793546945,243936947};
        System.out.println(new cc().longestNiceSubarray(nums));
    }



































  
   
}