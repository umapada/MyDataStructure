package com.array;

import java.util.Arrays;

/*

Find the longest substring with k unique characters in a given string
Given a string you need to print longest possible substring that has exactly M unique characters.
If there are more than one substring of longest possible length, then print any one of them.
Examples:

"aabbcc", k = 1
Max substring can be any one from {"aa" , "bb" , "cc"}.

"aabbcc", k = 2
Max substring can be any one from {"aabb" , "bbcc"}.

"aabbcc", k = 3
There are substrings with exactly 3 unique characters
{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
Max is "aabbcc" with length 6.

"aaabbb", k = 3
There are only two unique characters, thus show error message.

 */
/*
The problem can be solved in O(n). Idea is to maintain a window and add elements to the window till it contains less or
equal k, update our result if required while doing so. If unique elements exceeds than required in window, start removing
the elements from left side.

Below are the implementations of above. The implementations assume that the input string alphabet contains only 26
characters (from ‘a’ to ‘z’). The code can be easily extended to 256 characters.
 */
public class LongestSubstringWithKUniqueChar {

    static int MAX_CHAR = 256;
    static int []sChar = new int[MAX_CHAR];

    public static void main(String[] args) {
        int i = lengthOfLongestSubstringKDistinct("ab", 1);
        System.out.println(i);
    }


    public static  int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null || (s != null && s.trim().length() ==0) || k ==0){
            return 0;
        }
        int max_window = 1;
//        if(uniqChar(s) < k){
//            return 0;
//        }

        Arrays.fill(sChar, 0);

        int start_window = 0;
        int end_window = 0;
        sChar[s.charAt(0)]++;
        for(int i=1; i< s.length(); i++){

            sChar[s.charAt(i) ] ++;
            end_window++;

            while (!valid(k)){
                sChar[s.charAt(start_window)] --;
                start_window++;
            }

            if(max_window < end_window - start_window + 1){
                max_window = end_window - start_window + 1;

            }

        }

        return max_window;
    }


    static int uniqChar(String s){
        int count=0;
        for(int i=0; i < s.length(); i ++){
            if(sChar[s.charAt(i)] == 0){
                count++;
            }
            sChar[s.charAt(i)] ++;
        }
        return count;
    }

    static boolean valid(int k){
        int count = 0;
        for(int i=0; i < sChar.length; i++){
            if(sChar[i] > 0){
                count++;
            }
        }
        return k>=count;
    }
}
