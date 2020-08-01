package com;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;



class TEST {

    public static void main(String[] args) {
          String s =   Integer.toUnsignedString(12,64);
        System.out.println(s);
    }

    public int minDistance(String word1, String word2) {
        //minimum number of operations required to convert word1 to word2
        // Make word1 > word2
        int m = word1.length();
        int n = word2.length();
        if (n * m == 0) return n + m;
        int[] dp = new int[n + 1];
        for(int i = 0;i<n;i++) dp[i] = i;//initialize, compare "" with word2
        for(int i = 0;i<m;i++){
            int[] next = new int[n + 1];
            next[0] = i+1;                 //initialize compare word1 with ""
            for(int j = 0;j< n;j++){
                if(word1.charAt(i) == word2.charAt(j)) next[j+1] = dp[j];
                    // Minimize between replace, delete or insert
                else next[j+1] = Math.min(next[j],Math.min(dp[j],dp[j+1])) + 1;
            }
            dp = next;
        }
        return dp[n];
    }
}