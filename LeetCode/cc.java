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
      int x = Integer.MAX_VALUE;
      int y = Integer.MIN_VALUE;
      System.out.println("max:"+(x+1));
      System.out.println("min:"+y);
    }
}
  