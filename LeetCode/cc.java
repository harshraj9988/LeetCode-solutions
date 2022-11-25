import java.util.*;
import java.io.*;
public class cc {



    public static void main(String[] args) throws IOException {
        new cc().printWelcomeMsg("user", 10);
    }

    private void printWelcomeMsg(String user, int n){
        System.out.println("Welcome "+user+" and the generated token is: token-"+generateToken(n));
    }

    private long generateToken(int n){
        if(n==1) return 1l;
        long token = (long)Math.pow(10, n-1);
        return token+1;
    }
}