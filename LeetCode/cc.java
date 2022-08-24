import java.util.*;

public class cc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }
        System.out.println(binarySearchApproach(nums));

    }

    private static int binarySearchApproach(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(nums[0]);
        int size = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int ind = Collections.binarySearch(arr, num);
            if (ind < 0) {
                ind *= -1;
                ind--;
                if (ind == size) {
                    arr.add(num);
                    size++;
                } else {
                    arr.set(ind, num);
                }
            }
        }
        return size;
    }
}