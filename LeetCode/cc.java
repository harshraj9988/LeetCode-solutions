import java.util.*;

public class cc {
    public static long findMaximumSum(List<Integer> stockPrices, int k) {
        int n = stockPrices.size();

        Set<Integer> set = new HashSet<>();
        long maxSum = -1;

        long sum = 0;

        int t = k;

        for (int i = 0; i < n ; i++) {
            Integer sp = stockPrices.get(i);

            if (t == 0) {
                Integer temp = stockPrices.get(i - k);
                sum -= temp;
                set.remove(temp);

                if (set.contains(sp)) {
                    sum = 0;
                    set.clear();
                    i--;
                    t = k;
                    continue;
                }

                sum += sp;
                set.add(sp);
                
            } else {
                
                t--;

                if (set.contains(sp)) {
                    sum = 0;
                    set.clear();
                    i--;
                    t = k;
                    continue;
                }

                sum += sp;
                set.add(sp);
               
            }
            maxSum = Math.max(sum, maxSum);
            
        }

        return maxSum;
    }

    public static void main(String[] args) {
        List<Integer> stockPrices = new ArrayList<>();
        

        String s = "1 2 7 7 4 3 6 3";

        String[] arr = s.split(" ");
        for (String i : arr) {
            stockPrices.add(Integer.parseInt(i));
        }
        int k = stockPrices.remove(stockPrices.size()-1);

        long ans = cc.findMaximumSum(stockPrices, k);
        System.out.println(ans);
    }
}
