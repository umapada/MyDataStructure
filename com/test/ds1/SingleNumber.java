package com.test.ds1;

//Given an array of integers, every element appears twice except for one. Find that single one.


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class SingleNumber {

    public static void main(String[] args) {
        int [] A = {2,5,3,4,7,8,3};
        System.out.println(singleNumber_1(A));
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
        return it.next();
    }

  /*  public static int singleNumber8(int[] elements)
    {

        return Arrays.stream(elements).reduce(0,(a, b) -> a ^ b);
    }
    */



}
