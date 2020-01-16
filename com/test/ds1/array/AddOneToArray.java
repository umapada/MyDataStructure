package com.test.ds1.array;

import java.util.*;


/**
 * An integer is given in an array, which reoresent each element as digit. Add "1" to the given number
 */

/**
 * Solution1 => Convert array to integer, add one, convert back to array
 */
public class AddOneToArray {

    public static void main(String[] args) {
        int i[] = {9, 9};
//        int[] p = plusOne(i);
//
//        Arrays.stream(p).forEach(System.out::println);
        double res = 0;
        int count = 0;
        for (int k = i.length -1 ; k >= 0; k --){

            res = res +  Math.pow(10, count++) * i[k];
        }

        res = res + 1;
        int ret = (int)res;

        String s = String.valueOf(ret);

        int [] finalRes = new int[s.length()];

        count = s.length()-1;
        while (ret != 0){
            finalRes[count--] = ret %10;
            ret  = ret/10;
        }

        Arrays.stream(finalRes).forEach(System.out::println);

    }

    public static int[] plusOne(int[] digits) {
        int[] ret = new int[1];

        List<Integer> list = new ArrayList<>();
        int carry = 0;
        int last = digits[digits.length - 1];

        if (last == 9) {
            carry = 1;
            digits[digits.length - 1] = 0;
        } else {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
        }
        list.add(digits[digits.length - 1]);
        if (digits.length == 1 && last == 9) {
            list.add(1);
            carry = 0;
        }
        for (int i = digits.length - 2; i >= 0; i--) {

            if (carry == 1) {
                if (digits[i] == 9) {
                    carry = 1;
                    list.add(0);
                } else {
                    carry = 0;
                    list.add(digits[i] + 1);
                }
            } else {
                list.add(digits[i]);
            }
        }
        if (carry != 0) {
            list.add(1);
        }
        Collections.reverse(list);
        ret = list.stream().mapToInt(i -> i).toArray();

        return ret;
    }

}
