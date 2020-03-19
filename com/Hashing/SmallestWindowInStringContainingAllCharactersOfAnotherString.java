package com.Hashing;


/**
 * Find the smallest window in a string containing all characters of another string
 * Given two strings string1 and string2, the task is to find the smallest substring in string1 containing all characters of string2 efficiently.
 *
 * Examples:
 *
 * Input: string = “this is a test string”, pattern = “tist”
 * Output: Minimum window is “t stri”
 * Explanation: “t stri” contains all the characters of pattern.
 *
 *
 *
 * Input: string = “geeksforgeeks”, pattern = “ork”
 * Output: Minimum window is “ksfor”
 *
 */


/**
 * First check if the length of string is less than the length of the given pattern, if yes then “no such window can exist “.
 * Store the occurrence of characters of the given pattern in a hash_pat[].
 * Start matching the characters of pattern with the characters of string i.e. increment count if a character matches.
 * Check if (count == length of pattern ) this means a window is found.
 * If such window found, try to minimize it by removing extra characters from the beginning of the current window.
 * Update min_length.
 * Print the minimum length window.
 */
public class SmallestWindowInStringContainingAllCharactersOfAnotherString {

    static final int no_of_chars = 256;


    public static void main(String[] args)
    {
        String str = "this is a test string";
        String pat = "tist";

        System.out.print("Smallest window is :\n " +  findSubString(str, pat));
    }

    // Function to find smallest window containing all characters of 'pat'
    static String findSubString(String str, String pat)
    {
        int len1 = str.length();
        int len2 = pat.length();

        // check if string's length is less than pattern's length. If yes then no such window can exist
        if (len1 < len2)
        {
            System.out.println("No such window exists");
            return "";
        }

        int hash_pat[] = new int[no_of_chars];
        int hash_str[] = new int[no_of_chars];

        // store occurrence ofs characters of pattern
        for (int i = 0; i < len2; i++)
            hash_pat[pat.charAt(i)]++;

        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

        // start traversing the string
        int count = 0; // count of characters
        for (int j = 0; j < len1 ; j++)
        {
            // count occurrence of characters of string
            hash_str[str.charAt(j)]++;

            // If string's char matches with pattern's char then increment count
            if (hash_pat[str.charAt(j)] != 0 && hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)] )
                count++;

            // if all the characters are matched
            if (count == len2)
            {
                // Try to minimize the window i.e., check if any character is occurring more no. of times than its occurrence in pattern, if yes
                // then remove it from starting and also remove the useless characters.
                while ( hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]
                        || hash_pat[str.charAt(start)] == 0)
                {

                    if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
                        hash_str[str.charAt(start)]--;
                    start++;
                }

                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window)
                {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        // If no window found
        if (start_index == -1)
        {
            System.out.println("No such window exists");
            return "";
        }

        // Return substring starting from start_index and length min_len
        return str.substring(start_index, start_index + min_len);
    }


}
