package com.test.ds1.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Algorithm to find a substring from a string, which have at most two distict char.
 */
public class AtMostTwoDistinctCharacters {
    public static void main(String[] args) {


      //  String s = "aaabaabbaaaacaabdabbce";
        String s = "ccaabbb";
        s = "ababffzzeee";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null){
            return 0;
        } else if (s.length() == 1){
            return 1;
        } else if (s.length() == 2){
            return 2;
        }
        int prvchrCount = 0, chr2 = 0;
        int max = 0;
        char [] chrArray = s.toCharArray();
        Set set = new HashSet<Character>();
        int count = 0;
        for(int i =0; i<chrArray.length; i ++){
            if(set.size()<2 || (set.size() ==2 && set.contains(chrArray[i]))){
                count ++;
                set.add(chrArray[i]);
                max = Math.max(max, count);
                if(i != 0 && chrArray[i-1] == chrArray[i]){
                    prvchrCount ++;
                }else {
                    prvchrCount = 0;
                }
            }else{
                set.clear();
                set.add(chrArray[i-1]);
                set.add(chrArray[i]);
                count = 2 + prvchrCount;
                prvchrCount = 0;
            }
        }


        return max;
    }

}
