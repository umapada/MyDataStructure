package com.array.slidingwindow;
//LongestSubstring - without repeating characters
public class LongestSubstring_No_Repeat_Char {

    public static void main(String[] args) {
        String s = "ZZDAOBECODEBANC";
        System.out.println(lengthOfLongestSubstring2(s));
    }

    static int lengthOfLongestSubstring2(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] == 1) counter++;
            map[c1]++;
            end++;

            while (counter > 0) {
                final char c2 = s.charAt(start);
                if (map[c2] > 1) counter--;
                map[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }
}
