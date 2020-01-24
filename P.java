import java.util.Scanner;

import static java.lang.Math.log;
import static java.lang.Math.log10;

public class P {

    public static void main(String[] args) {

        int input = '9';
        System.out.println("10 " + (char)(254) + (char)61 + " 100") ;


    }

   static int countNumber(long num){
        if(num == 0){
            return 0;
        } else{
            return  1 + countNumber(num/10);
        }
    }
}
