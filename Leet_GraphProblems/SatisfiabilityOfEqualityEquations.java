package Leet_GraphProblems;
/*
//https://leetcode.com/problems/satisfiability-of-equality-equations/

Given an array equations of strings that represent relationships between variables, each string equations[i] has
length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters
(not necessarily different) that represent one-letter variable names.

Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.



Example 1:

Input: ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.
Example 2:

Input: ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
Example 3:

Input: ["a==b","b==c","a==c"]
Output: true
Example 4:

Input: ["a==b","b!=c","c==a"]
Output: false
Example 5:

Input: ["c==c","b==d","x!=z"]
Output: true
 */

class SatisfiabilityOfEqualityEquations {
    int[] uf = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; ++i) {
            uf[i] = i;
        }
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                uf[find(e.charAt(0) - 'a')] = find(e.charAt(3) - 'a');
            }
        }
        for (String e : equations) {
            if (e.charAt(1) == '!' && find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
    }

    public int find(int x) {
        if (x != uf[x]) {
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }
}

