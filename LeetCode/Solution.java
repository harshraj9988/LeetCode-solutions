import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int x = 1;
        while(t-->0){
            int n = input.nextInt();
            int[] ratings = new int[n];
            for(int i=0; i<n; i++){
                ratings[i] = input.nextInt();
            }
            System.out.print("Case #"+x+": ");

            System.out.println();
            x++;
        }
    }
    
    private static int[] solve(int[] ratings){
        
    }
}