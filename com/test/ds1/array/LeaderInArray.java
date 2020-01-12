package com.test.ds1.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Write a program to print all the LEADERS in the array. An element is leader if it is greater
 * than all the elements to its right side. And the rightmost element is always a leader.
 * For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 */

public class LeaderInArray {

    public static void main(String[] args) {
        int [] num = {16,17,4,3,5,2};

        int [] ret = leader(num);

        Arrays.stream(ret).forEach(System.out::println);
    }


    static int [] leader(int[] num){

        List<Integer> list = new ArrayList<>();
        list.add(num[num.length-1]);
        int max_element = num[num.length-1];
        for(int i = num.length-2; i >= 0; i --){
            if(num[i] >= max_element){
                list.add(num[i]);
                max_element = num[i];
            }
        }

        Collections.reverse(list);

        return list.stream().mapToInt(k -> k).toArray();
    }

}
