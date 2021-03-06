package extra;

//Given an array of integers, every element appears twice except for one. Find that single one.


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class SingleNumber {

    public static void main(String[] args) {
        int [] A = {2,5,2,4,7,4,7};
        System.out.println(singleNumber_2(A));
    }


    public static int singleNumber_1(int[] A) {
        int x = 0;
        for (int a : A) {
            x = x ^ a;
        }
        return x;
    }

    public static int singleNumber_2(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : A) {
            if (!set.add(n))
                set.remove(n);
        }
        Iterator<Integer> it = set.iterator();
        int p = 0;
        for (Integer x : set) {
            p=x;
        }

        return p;
    }

  /*  public static int singleNumber8(int[] elements)
    {

        return Arrays.stream(elements).reduce(0,(a, b) -> a ^ b);
    }
    */



}
