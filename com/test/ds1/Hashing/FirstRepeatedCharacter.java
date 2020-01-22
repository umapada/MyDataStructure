package com.test.ds1.Hashing;

/**
 * Find the first repeated character in a string
 * Given a string, find the first repeated character in it. We need to find the character that occurs more than once
 * and whose index of second occurrence is smallest
 *
 * Examples:
 *
 *
 *
 * Input: ch = “geeksforgeeks”
 * Output: e
 * e is the first element that repeats
 *
 * Input: str = “hello geeks”
 * Output: l
 * l is the first element that repeats
 *
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Create an empty hash.
 * Scan each character of input string and insert values to each keys in the hash.
 * When any character appears more than once, hash key value is increment by 1, and return the character.
 */
public class FirstRepeatedCharacter {

    public static void main (String[] args)
    {
        String str = "geeksforgeeks";
        char[] arr = str.toCharArray();
        System.out.println(firstRepeating(arr));
    }

    static char firstRepeating(char str[])
    {
        // Creates an empty hashset
        Set<Character> h = new HashSet<>();

        // Traverse the input array from left to right
        for (int i=0; i<=str.length-1; i++)
        {
            char c = str[i];

            // If element is already in hash set, update x
            // and then break
            if (h.contains(c))
                return c;

            else // Else add element to hash set
                h.add(c);
        }

        return '\0';
    }

}
