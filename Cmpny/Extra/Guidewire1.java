package Cmpny.Extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Guidewire1 {

    public static void main(String[] args) {

      //  solution(341);

       System.out.println(solution(100000001));
    }


    public static int solution(int N) {
        // write your code in Java SE 8

        // Returning -1, if input less than 0 or greater than 100000000
        if(N < 0 || N > 100000000){
            return -1;
        }

        long retNumber = 0;
        int x = 0;
        List<Integer> list = new ArrayList<>();
        // Take each digit and add to a arrayList
        while(N > 0){
            x = N % 10;
            list.add(x);
            N = N/10;
        }

        //Sort the list in reverse order
        Collections.sort(list, Collections.reverseOrder());

        // Create the number by taking each digit from list.
        for(int k : list){
            retNumber = retNumber * 10 + k;
        }

        // If digit greater than 100000000, return -1;
        if(retNumber > 100000000){
            return -1;
        }else{
           return (int)retNumber;
        }
    }

}
