package com.test.ds1.array;

import java.math.BigDecimal;
import java.util.*;

public class AddOneToArray {

    public static void main(String[] args) {
        int i[] = {9, 9};
        int[] p = plusOne(i);
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
