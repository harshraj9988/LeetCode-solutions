import java.util.*;

public class cc {
    
    public int maximumGroups(int n) {
       
        int x = 1, y = 0;
        while(n>0){
            n -= x;
            y++;
            x++;
            if(x>n) break;
        }
        return y;
    }

    

    public static void main(String[] args) {
       int n = 10;
       System.out.println(new cc().maximumGroups(n));
    }
}
  