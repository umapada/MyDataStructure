package com.test.ds1.array;

import java.util.Arrays;

/**
 * Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N
 * is an element that appears more than N/2 times in the array.
 */

public class MajorityElement {

    public static void main(String[] args) {

        int num [] = {2,2,3,3,2,3,3};

        //System.out.println(majority(num));

        Arrays.stream(num).forEach(System.out::println);
    }

    static int majority(int [] numbers){
        int size = numbers.length;
        int cand = numbers[0];
        int count = 1;


        for(int i = 1; i < size; i ++){
            if(numbers[i] == cand){
                count ++;
            }else{
                count --;
            }
            if(count == 0){
                cand = numbers[i];
                count = 1;
            }
        }

        count = 0;
        for(int i = 0; i < size; i ++){
            if(cand == numbers[i]){
                count ++;
            }
        }

        if(count > size/2){
            return  cand;
        }

        return -1;
    }


}
