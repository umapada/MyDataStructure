package com.test.ds1.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a function to check whether two given strings are anagram of each other or not. An anagram of a string is
 * another string that contains same characters, only the order of characters can be different.
 * For example, “abcd” and “dabc” are anagram of each other.
 */

// Solution-1 : Sort and comapre => O(nlogn)

/**
 * static boolean areAnagram(char[] str1, char[] str2)
 *     {
 *         // Get lenghts of both strings
 *         int n1 = str1.length;
 *         int n2 = str2.length;
 *
 *         // If length of both strings is not same,
 *         // then they cannot be anagram
 *         if (n1 != n2)
 *             return false;
 *
 *         // Sort both strings
 *         Arrays.sort(str1);
 *         Arrays.sort(str2);
 *
 *         // Compare sorted strings
 *         for (int i = 0; i < n1; i++)
 *             if (str1[i] != str2[i])
 *                 return false;
 *
 *         return true;
 *     }
 */


//Solution2

/**
 * Method 2 (Count characters)
 * This method assumes that the set of possible characters in both strings is small. In the following implementation,
 * it is assumed that the characters are stored using 8 bit and there can be 256 possible characters.
 *
 * Create count arrays of size 256 for both strings. Initialize all values in count arrays as 0.
 * Iterate through every character of both strings and increment the count of character in the corresponding count arrays.
 * Compare count arrays. If both count arrays are same, then return true.
 */

/**
 * Method 3 (count charcters using one array)
 *
 * The above implementation can be further to use only one count array instead of two. We can increment the value in
 * count array for characters in str1 and decrement for characters in str2. Finally, if all count values are 0,
 * then the two strings are anagram of each other. Thanks to Ace for suggesting this optimization.
 *
 *
 * bool areAnagram(char* str1, char* str2)
 * {
 *     // Create a count array and initialize all values as 0
 *     int count[NO_OF_CHARS] = { 0 };
 *     int i;
 *
 *     // For each character in input strings, increment count in
 *     // the corresponding count array
 *     for (i = 0; str1[i] && str2[i]; i++) {
 *         count[str1[i]]++;
 *         count[str2[i]]--;
 *     }
 *
 *     // If both strings are of different length. Removing this condition
 *     // will make the program fail for strings like "aaca" and "aca"
 *     if (str1[i] || str2[i])
 *         return false;
 *
 *     // See if there is any non-zero value in count array
 *     for (i = 0; i < NO_OF_CHARS; i++)
 *         if (count[i])
 *             return false;
 *     return true;
 * }
 *
 */

public class Anagram {

    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();

        String str1 = "allergy";
        String str2 = "alleryg";
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
