package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P {

    // Driver code
    public static void main(String[] args)
    {

        String a1 = "ABCDGH";
        String a2 = "ACDGHR";

        String str = longestCommonSubstring(a1,a2);

        System.out.println(str);


    }


    private static String longestCommonSubstring(String a1, String a2){
        String retString = "";
        int maxLength = 0;
        char[] c1 = a1.toCharArray();
        char [] c2 = a2.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i < c1.length; i ++){
            map.put(c1[i], i);
        }
        boolean found = false;
        int index = 0;
        String tempString = "";
        for(int i=0; i < c2.length; i++){
            if(map.get(c2[i]) != null){
                found = true;
                index = i;
                while (found){
                        tempString = tempString + c2[index++];
                        if(map.get(c2[index]) != null && (map.get(c2[index]) != map.get(c2[index-1]) + 1 )){
                            found = false;
                        }
                        if(map.get(c2[index]) == null){
                            break;
                        }
                        if(index >= c2.length){
                            break;
                        }
                }

                if(retString.length() < tempString.length()){
                    retString = tempString;
                }
                tempString = "";

            }
        }
        return  retString;
    }



}
