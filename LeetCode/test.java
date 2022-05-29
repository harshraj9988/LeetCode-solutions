public class test{
    public static void main(String[] args) {
        String abc="";

        String part1;
        String part2;
        if(abc.contains("of")){
            String[] str = abc.split("of");
             part1= str[0] + "of";
             part2= str[1];
        }
        else{
             part1= "Near of";
             part2= abc;
        }

        System.out.println(part1);
        System.out.println(part2);
    }
}