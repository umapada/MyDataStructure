package TEST;

/*
Find the Longest Substring Containing Vowels in Even Counts

Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.



Example 1:

Input: s = "eleetminicoworoep"
Output: 13
Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.
Example 2:

Input: s = "leetcodeisgreat"
Output: 5
Explanation: The longest substring is "leetc" which contains two e's.
Example 3:

Input: s = "bcbcbc"
Output: 6
Explanation: In this case, the given string "bcbcbc" is the longest because all vowels: a, e, i, o and u appear zero times.


Constraints:

1 <= s.length <= 5 x 10^5
s contains only lowercase English letters.


// SOLUTION

https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/discuss/531840/JavaPython-One-Pass

Same idea, we use a state to encode the vowels inforation for prefix string end at index i.

1. State has 5 bits, each bits to indicate if the corresponding vowel have even count or not.

2. When current index have a vowel character, we use bitwise xor to toggle the bit value. state ^= (1 << digit);

3. For the substring between two index have identical state, then all vowels's count are even number.

Eg if from 0 - i, we have even number of 'a', and from 0- j, if we have even number of 'a' again, then the substring
between i and j will have even number of 'a' as well. This would be the same if 0 - i and 0 - j both have odd number of 'a'.
Suggested by @multics, we are tracking the value that corresponds to the value of the desired bit to flip. In this way,
we can avoid bit shifting.

*/

import java.util.HashMap;

public class LongestSubstringVowelsEvenCounts {

    public static void main(String[] args) {
        int out = new LongestSubstringVowelsEvenCounts().findTheLongestSubstring("leetcodeisgreat"); //Ans is "leetc"
        System.out.println(out);
    }

    HashMap<Character, Integer> vowlToBitIndex = new HashMap<Character, Integer>() {
        {
            put('a', 1);
            put('e', 2);
            put('i', 4);
            put('o', 8);
            put('u', 16);
        }
    };

    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> stateToIndex = new HashMap<>();
        stateToIndex.put(0, -1);
        int state = 0, maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(vowlToBitIndex.containsKey(cur)) {
                // flap the digits of the state. 1-> 0 or 0 -> 1
                int bitToFlip = vowlToBitIndex.get(cur);
                //XOR state with bitToFlip
                state ^= bitToFlip;
            }
            stateToIndex.putIfAbsent(state, i);
            maxLen = Math.max(maxLen, i - stateToIndex.get(state));
        }
        return maxLen;
    }


}
