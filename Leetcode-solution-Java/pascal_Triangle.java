

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

        //     1
        //    1 1
        //   1 2 1
        //  1 3 3 1
        // 1 4 6 4 1 
    

    // Example 1:

    // Input: numRows = 5
    // Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    // Example 2:

    // Input: numRows = 1
    // Output: [[1]]
    

    // Constraints:

    // 1 <= numRows <= 30
    import java.util.*;
public class pascal_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        
        int n=numRows;

        for(int i=0;i<n;i++){
            ArrayList<Integer> a=new  ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) a.add(1);
                else{
                    int x,y,z;
                    x=result.get(i-1).get(j);
                    y=result.get(i-1).get(j-1);
                    z=x+y;
                    a.add(z);
                }
            }
            result.add(a);
            
        }


        return result;
    }
}
