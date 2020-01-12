package com.test.ds1.array;

import java.util.HashMap;
import java.util.Map;

public class Anagram {


    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();

        String str1 = "allergy";
        String str2 = "allergic";
        boolean anagram = true;

        char [] chr1 = str1.toCharArray();
        char [] chr2 = str2.toCharArray();
        if(chr1.length != chr2.length){
            System.out.println("Not Anagram");
        }else{
            for(int i = 0; i < chr1.length; i ++){
                if(map.get(chr1[i]) == null){
                    map.put(chr1[i], 1);
                }else{
                    map.put(chr1[i] , map.get(chr1[i]) + 1);
                }
            }

            for(int i = 0; i < chr2.length; i ++){
                if(map.get(chr2[i]) == null){
                    System.out.println("Not Anagram");
                    anagram = false;
                    break;
                }
            }
            if(anagram) {
                System.out.println("Its Anagram");
            }
        }


    }

}
