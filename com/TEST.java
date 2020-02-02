package com;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class TEST {
    private List<String> names;

    static int p = 0;

    public static void main(String[] args) throws Exception {


        long a = new Date().getTime();
        System.out.println(F2(48));
        System.out.println(new Date().getTime() - a);
        System.out.println("---------------");

         a = new Date().getTime();
        System.out.println(F(20));
        System.out.println(new Date().getTime() - a);



    }



    static int F(int n){
        int out;
        if(n<=1)
            return n;
      //  }else{
            return F(n-1) + F(n-2);
      //  }

    }


    static int F2(int n){
        int [] p = new int [n];

        p[0] = 1;
        p[1] = 1;

        for (int i =2; i< n ; i ++){
            p[i] = p[i-1] + p[i-2];
        }

        return p[n-1];
    }

    private static void SumInt() {
        String a = "123a2";

        String temp = "0";

        int sum =0;
        for (int i =0 ; i < a.length() ; i ++){

            char c = a.charAt(i);
            if(Character.isDigit(c)){
               temp+=c;
            }else{
                sum = sum + Integer.parseInt(temp);
                temp="0";
            }



        }

        sum = sum + Integer.parseInt(temp);

        System.out.println(sum);
    }


}