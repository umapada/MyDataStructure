import java.util.Scanner;

import static java.lang.Math.log;
import static java.lang.Math.log10;

public class P {

    public static void main(String[] args) {

Scanner scan = new Scanner(System.in);

int i = scan.nextInt();




    }

   static int countNumber(long num){
        if(num == 0){
            return 0;
        } else{
            return  1 + countNumber(num/10);
        }
    }
}
