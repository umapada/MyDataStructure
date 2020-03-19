package Math;
/*
Program for nth Catalan Number
Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems like following.
1) Count the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3, possible
expressions are ((())), ()(()), ()()(), (())(), (()()).

2) Count the number of possible Binary Search Trees with n keys (See this)



3) Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves.

See this for more applications.

The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …


Recursive Solution
Catalan numbers satisfy the following recursive formula.
C0=1 and Cn1=sum{i=0-n} Ci * Cn - i  for n geq 0;
Following is the implementation of above recursive formula.

 */

import java.util.Date;

public class CatalanNumber {

    public static void main(String[] args) {
        long time1 = new Date().getTime();
        long out = catalanBC(40000);
        long time2= new Date().getTime();
        System.out.println(time2-time1);
       // System.out.println(out);
    }

    static long catalan(int n){
        long res = 0;
        if (n<=0){
            return 1;
        }
        for(int i=0; i < n; i++){
            res += catalan(i) * catalan(n-i-1);
        }
        return res;
    }
    //Time complexity of above implementation is equivalent to nth catalan number.
    //The value of nth catalan number is exponential that makes the time complexity exponential.

/*
Dynamic Programming Solution
We can observe that the above recursive implementation does a lot of repeated work (we can the same by drawing recursion
tree). Since there are overlapping subproblems, we can use dynamic programming for this. Following is a Dynamic
programming based implementation
 */


    static long catalanDP(int n) {
        // Table to store results of subproblems
        long catalan[] = new long[n + 2];

        // Initialize first two values in table
        catalan[0] = 1;
        catalan[1] = 1;

        // Fill entries in catalan[] using recursive formula
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        // Return last entry
        return catalan[n];
    }

    //Time Complexity: Time complexity of above implementation is O(n2)

    /*
    Using Binomial Coefficient
    We can also use the below formula to find nth catalan number in O(n) time.
    C_n=\frac{1}{n+1}\binom{2n}{n}
    */

    // A Binomial coefficient based function to find nth catalan
// number in O(n) time
    static long catalanBC(int n) {
        // Calculate value of 2nCn
        long c = binomialCoeff(2 * n, n);

        // return 2nCn/(n+1)
        return c / (n + 1);
    }

    // Returns value of Binomial Coefficient C(n, k)
    static long binomialCoeff(int n, int k) {
        long res = 1;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k) {
            k = n - k;
        }

        // Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }
//Time Complexity: Time complexity of above implementation is O(n).
}
