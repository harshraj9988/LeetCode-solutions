/**

*/

import java.util.*;
import java.util.Map.Entry;
class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Integer> result = new ArrayList<>();
        HashSet<String> pos = new HashSet<>();
        HashSet<String> neg = new HashSet<>();
        int x = 0;
        
        for(String p: positive_feedback) pos.add(p);
        for(String n: negative_feedback) neg.add(n);
        HashMap<Integer, Integer> point = new HashMap<>();
        for(int i: student_id) point.put(i, 0);
        int n = report.length;
        for(int i=0; i<n; i++){
            String[] rats = report[i].split(" ");
            for(String rat: rats) {
                if(pos.contains(rat)) point.put(student_id[i], point.get(student_id[i])+3);
                else if(neg.contains(rat)) point.put(student_id[i], point.get(student_id[i])-1);
            }  
        }
        int[][] temp = new int[point.size()][2];
        for(Entry<Integer, Integer> e: point.entrySet()) {
            temp[x][0] = e.getValue();
            temp[x++][1] = e.getKey();
        }
        Arrays.sort(temp, (a,b)->(b[0]==a[0])?a[1]-b[1]:b[0]-a[0]);
        for(int[] z: temp) {
            result.add(z[1]);
            k--;
            if(k==0) break;
        }
        return result;
    }

    public int captureForts(int[] forts) {
        int ans = 0;
        int n = forts.length;

        for(int i=0; i<n; i++) {
            int temp = 0;
            int j = 0;
            
            if(forts[i]==1)
            for( j= i-1; j>=0; j--) {
                if(forts[j]==1){
                    temp = 0;
                    break;
                }else if(forts[j]==-1) break;
                temp++;
            }
            if(j!=-1)
            ans = Math.max(temp, ans);

            if(forts[i]==1)
            for (j = i+1; j<n; j++) {
                if(forts[j]==1){
                    temp = 0;
                    break;
                }else if(forts[j]==-1) break;
                temp++;
            }
            if(j!=n)
            ans = Math.max(temp, ans);
            temp = 0;
        }

        return ans;
    }

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        HashSet<Integer> as = new HashSet<>();
        ArrayList<Integer> al = new ArrayList<>(), bl = new ArrayList<>();
        int a = 0, b = 0;
        int ad = 1, bd = 1;
        if(uniqueCnt1 >= uniqueCnt2) {
            a = uniqueCnt1;
            b = uniqueCnt2;
            ad = divisor1;
            bd = divisor2;
        }else if( uniqueCnt2 > uniqueCnt1) {
            a = uniqueCnt2;
            b = uniqueCnt1;
            ad = divisor2;
            bd = divisor1;
        }
        for(int i=1; i <= 1e9; i++) {
            if(i%ad!=0 && al.size()<a) {
                al.add(i);
            }else if(i%bd!=0 && bl.size()<b){
                bl.add(i);
            }
            if(al.size()==a && bl.size()==b) break;
        }
        int max = 0;
        for(Integer i: al) {
            max = Math.max(i, max);
        }
        for(Integer i: bl) {
            max = Math.max(i, max);
        }

        return max;
    }
}