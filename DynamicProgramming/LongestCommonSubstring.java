package DynamicProgramming;

/**
 * Longest Common Substring | DP-29
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 * Examples :
 *
 * Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
 * Output : 5
 * The longest common substring is “Geeks” and is of length 5.
 *
 * Input : X = “abcdxyz”, y = “xyzabcd”
 * Output : 4
 * The longest common substring is “abcd” and is of length 4.
 *
 * Input : X = “zxabcdezy”, y = “yzabcdezx”
 * Output : 6
 * The longest common substring is “abcdez” and is of length 6.
 */


/**
 * Let m and n be the lengths of first and second strings respectively.
 *
 * A simple solution is to one by one consider all substrings of first string and for every substring check if it is a
 * substring in second string. Keep track of the maximum length substring. There will be O(m^2) substrings and we can
 * find whether a string is subsring on another string in O(n) time (See this). So overall time complexity of this
 * method would be O(n * m2)
 *
 * Dynamic Programming can be used to find the longest common substring in O(m*n) time. The idea is to find length of
 * the longest common suffix for all substrings of both strings and store these lengths in a table.
 *
 * The longest common suffix has following optimal substructure property.
 *
 * If last characters match, then we reduce both lengths by 1
 * LCSuff(X, Y, m, n) = LCSuff(X, Y, m-1, n-1) + 1 if X[m-1] = Y[n-1]
 * If last characters do not match, then result is 0, i.e.,
 * LCSuff(X, Y, m, n) = 0 if (X[m-1] != Y[n-1])
 *
 * Now we consider suffixes of different substrings ending at different indexes.
 * The maximum length Longest Common Suffix is the longest common substring.
 * LCSubStr(X, Y, m, n) = Max(LCSuff(X, Y, i, j)) where 1 <= i <= m and 1 <= j <= n
 */


public class LongestCommonSubstring {

    /*
       Returns length of longest common substring
       of X[0..m-1] and Y[0..n-1]
    */
    static int LCSubStr(char X[], char Y[], int m, int n)
    {
        // Create a table to store lengths of longest common suffixes of substrings. Note that LCSuff[i][j] contains length of longest
        // common suffix of X[0..i-1] and Y[0..j-1]. The first row and first column entries have no logical meaning, they are used only
        // for simplicity of program
        int LCStuff[][] = new int[m + 1][n + 1];
        int result = 0;  // To store length of the longest common substring

        // Following steps build LCSuff[m+1][n+1] in bottom up fashion
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i == 0 || j == 0)
                    LCStuff[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                {
                    LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
                    result = Integer.max(result, LCStuff[i][j]);
                }
                else
                    LCStuff[i][j] = 0;
            }
        }
        return result;
    }

    // Driver Program to test above function
    public static void main(String[] args)
    {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();

        System.out.println("Length of Longest Common Substring is " + LCSubStr(X.toCharArray(), Y.toCharArray(), m, n));
    }

    /**
     * Time Complexity: O(m*n)
     * Auxiliary Space: O(m*n)
     */
}
