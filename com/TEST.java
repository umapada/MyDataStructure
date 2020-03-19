package com;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;


public class TEST {

    static String out = "NO";
    public static void main(String[] args) throws Exception {

    MAT(1,1,1000,1000);

        System.out.println(out);
    }

    //TODO Going to infinite loop for 2 2
    static void  MAT(int i, int j, int targetI, int targetJ){
        if(i<1 || j < 1 || i>2000 || j >2000 || i> targetI || j > targetJ){
            return;
        }
        if(i == targetI && j == targetJ){
                out = "Yes";
                return;
        }else{
                  MAT(2*i, j, targetI, targetJ);
                  MAT(i, j-i, targetI, targetJ);
                  MAT(i-j, j, targetI, targetJ);
        }
    }

}