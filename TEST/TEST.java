package TEST;

import java.util.*;


public class TEST {
    static int x = 5;
    static int y = 1;
    public static void main(String[] args) {


        System.out.println(toHashkey());
    }

   static long toHashkey() {
        long ans = x;
        return (ans << 30) | y;
    }

}

