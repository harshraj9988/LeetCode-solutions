import java.util.Arrays;

public class cc {
    long colosseum(int N,int A[]) {
    
        Arrays.sort(A);
        long sum1 = 0;
        for (int i = N; i < (2*N)-1; i++) {
            sum1+=A[i];
        }
        long sum2 = 0;
        for (int i = (2*N); i < A.length; i++) {
            sum2+=A[i];
                }

        return sum2-sum1;
    }
}
