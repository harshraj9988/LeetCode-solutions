import java.util.*;

public class cc {
    static long solve(int N, int[] A, int[] B) {
        long sumA = 0;
        long sumB = 0;

        ArrayList<Integer> oddA = new ArrayList<>();
        ArrayList<Integer> evenA = new ArrayList<>();
        ArrayList<Integer> oddB = new ArrayList<>();
        ArrayList<Integer> evenB = new ArrayList<>();

    
        long diffpos = 0;
        long diffneg = 0;

        for (int i = 0; i < N; i++) {
            int a = A[i];
            int b = B[i];

            sumA += a;
            sumB += b;

            if (a % 2 == 0) {
                evenA.add(a);
            } else {
                oddA.add(a);
            }
            if (b % 2 == 0) {
                evenB.add(b);
            }else{
                oddB.add(b);
            }
        }

      
        int m = evenA.size();
        int n = oddA.size();

        evenA.sort((a, b)-> a-b );
        evenB.sort((a, b)-> a-b );
        oddA.sort((a, b)-> a-b );
        oddB.sort((a, b)-> a-b );

        for (int i = 0; i < m; i++) {
            int a = evenA.get(i);
            int b = evenB.get(i);
            if(b-a>=0) diffpos += (b-a);
            else diffneg += (b-a);
        }

        for (int i = 0; i < n; i++) {
            int a = oddA.get(i);
            int b = oddB.get(i);
            if(b-a>=0) diffpos += (b-a);
            else diffneg += (b-a);
        }

        if (sumA != sumB || evenA.size() != evenB.size() || (diffpos + diffneg != 0))
        return -1;

        System.out.println(diffpos+" "+diffneg);

        long result = diffpos / 2;

        if (diffpos % 2 == 1)
            result++;

        return result;
    }

    public static void main(String[] args) {
        int[] A = { 2,5,6 };
        int[] B = { 1, 2 ,10 };
        int N = 3;

        long ans = solve(N, A, B);
        System.out.println(ans);
    }
}
