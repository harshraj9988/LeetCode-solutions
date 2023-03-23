import java.util.Arrays;

public class maximizeWinFromTwoSegments {
    public int maximizeWin(int[] arr, int k) {
        int n = arr.length;
        
        int[] reach = new int[n];
        
        for(int i=0; i<n; i++) {
            int j = upperBound(arr, arr[i]+k);
            reach[i] = j-i+1;
        }
        
        int[] maxReach = new int[n];
        maxReach[n-1] = reach[n-1];
        
        for(int i=n-2; i>=0; i--){
            maxReach[i] = Math.max(reach[i], maxReach[i+1]);
        }

        int res = 0;

        for(int i=0; i<n; i++) {
            int j = upperBound(arr, arr[i]+k);
            int temp = reach[i];
            if(j<n-1) {
                temp+=maxReach[j+1];
            }
            res = Math.max(res, temp);
        }
        
        return res;
    }

    private int upperBound(int[] arr, int key) {
        int index = Arrays.binarySearch(arr, key);

        while (index >= 0) {
            index = Arrays.binarySearch(arr, index + 1, arr.length, key);
        }

        int ub = Math.abs(index) - 1;
        if (ub <= arr.length)
            return ub-1;
        else
            return arr.length-1;
    }

}
