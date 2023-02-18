public class Dl {
    public int singleNumber(final int[] A) {
        int ans = 0;
        for(int a : A) {
            ans = ans ^ a;
        }
        return ans;
    }

    public static void main(String[] args) {
        final int[] A = new int[]{2,2,3,3,4,4,13,5,5};
        System.out.println((new Dl()).singleNumber(A));
    }
}