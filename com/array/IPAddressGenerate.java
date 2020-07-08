package com.array;
/*
Generate IP Addresses
Given a string S containing only digits, Your task is to complete the function genIp() which returns a vector containing
all possible combination of valid IPv4 ip address and takes only a string S as its only argument.
Note : Order doesn't matter.

For string 11211 the ip address possible are
1.1.2.11
1.1.21.1
1.12.1.1
11.2.1.1
 */


import java.util.ArrayList;
import java.util.List;

class IPAddressGenerate {
    public static void main(String[] args) {
        String input = "101299";
        List<String> out = genIp(input);

        System.out.println(out);
    }

    static List<String> genIp(String s) {
        List<String> res = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    for (int l = 1; l <= 3; l++) {
                        if (i + j + k + l == s.length()) {
                            int a = Integer.parseInt(s.substring(0, i));
                            int b = Integer.parseInt(s.substring(i, i + j));
                            int c = Integer.parseInt(s.substring(i + j, i + j + k));
                            int d = Integer.parseInt(s.substring(i + j + k, i + j + k + l));

                            if (isOk(a, b, c, d)) {
                                String str = make(a, b, c, d);
                                /*+3 because of 3 dots*/
                                if (str.length() == s.length() + 3) {
                                    res.add(str);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    public static boolean isOk(int a, int b, int c, int d) {
        return a <= 255 && b <= 255 && c <= 255 && d <= 255;
    }

    public static String make(int a, int b, int c, int d) {
        return String.valueOf(a) + "." + String.valueOf(b) + "." + String.valueOf(c) + "." + String.valueOf(d);
    }
}