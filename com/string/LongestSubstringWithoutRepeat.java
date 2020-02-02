package com.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		
		System.out.println(lengthOfLongestSubstring("dvdffabv"));

	}
	
	public static int getSubString(String input) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = 0;
        int currentLen = 0;
        int start = 0;

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if(map.containsKey(c)) {
                int index = map.get(c);

                if(index < start) {
                    currentLen++;
                } else {
                    if(currentLen > maxLen)
                        maxLen = currentLen;

                    start = index + 1;
                    currentLen = i - start + 1;
                }
            } else {
                currentLen++;
            }

            map.put(c, i);
        }

        return currentLen > maxLen ? currentLen : maxLen;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
//dvdffabv
        int start = 0, end = 0, ans = 0;

        Set<Character> set = new HashSet<>();

        while (start < n && end < n){
            if(!set.contains(s.charAt(end))){
             set.add(s.charAt(end++)) ;
             ans = Math.max(ans, end - start);

            }else{
                set.remove(s.charAt(start++));
            }


        }

        return ans;
    }


}
