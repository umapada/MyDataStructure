package com.Hashing;

/**
 * Check if frequency of all characters can become same by one removal
 * Given a string which contains lower alphabetic characters, we need to remove at most one character from this string
 * in such a way that frequency of each distinct character becomes same in the string.
 *
 * Examples:
 *
 * Input: str = “xyyz”
 * Output: Yes
 * We can remove character ’y’ from above
 * string to make the frequency of each
 * character same.
 *
 *
 *
 * Input: str = “xyyzz”
 * Output: Yes
 * We can remove character ‘x’ from above
 * string to make the frequency of each
 * character same.
 *
 * Input: str = “xxxxyyzz”
 * Output: No
 * It is not possible to make frequency of
 * each character same just by removing at
 * most one character from above string.
 */

/**
 * The problem can be solved using the concept of hashing. The main thing to observe in this problem is that the
 * position of characters does not matter here so we will count the frequency of characters, if all of them are
 * the same then we are done and there is no need to remove any character to make frequency of characters same
 * Otherwise we can iterate over all characters one by one and decrease their frequency by one, if all frequencies
 * become same then we will flag that it is possible to make character frequency same by at most one removal and if
 * frequencies don’t match then we will increase that frequency again and loop for other characters.
 */

public class IfFrequenciesCanBeEqual {

    static final int M = 26;

    // Utility method to get index of character ch in lower alphabet characters
    static int getIdx(char ch)
    {
        return (ch - 'a');
    }

    // Returns true if all non-zero elements values are same
    static boolean allSame(int freq[], int N)
    {
        int same = 0;

        // get first non-zero element
        int i;
        for (i = 0; i < N; i++) {
            if (freq[i] > 0) {
                same = freq[i];
                break;
            }
        }

        // check equality of each element with variable same
        for (int j = i + 1; j < N; j++)
            if (freq[j] > 0 && freq[j] != same)
                return false;

        return true;
    }

    // Returns true if we can make all character frequencies same
    static boolean possibleSameCharFreqByOneRemoval(String str)
    {
        int l = str.length();

        // fill frequency array
        int[] freq = new int[M];

        for (int i = 0; i < l; i++)
            freq[getIdx(str.charAt(i))]++;

        // if all frequencies are same, then return true
        if (allSame(freq, M))
            return true;

        /*  Try decreasing frequency of all character
            by one and then check all equality of all
            non-zero frequencies */
        for (char c = 'a'; c <= 'z'; c++) {
            int i = getIdx(c);

            // Check character only if it occurs in str
            if (freq[i] > 0) {
                freq[i]--;

                if (allSame(freq, M))
                    return true;
                freq[i]++;
            }
        }

        return false;
    }

    // Driver code to test above methods
    public static void main(String args[])
    {
        String str = "xyyzz";
        if (possibleSameCharFreqByOneRemoval(str))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
