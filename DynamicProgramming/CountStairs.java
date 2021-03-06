package DynamicProgramming;

/*

Count ways to reach the nth stair using step 1, 2 or 3
A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
Implement a method to count how many possible ways the child can run up the stairs.

There are two methods to solve this problem
1. Recursive Method
2. Dynamic Programming

Examples :

Input : 4
Output : 7

Input : 3
Output : 4  (111, 12, 3, 21)

 */


/*

1. Recursive Method
How Code is Working :
Suppose you have n stairs then you can hop either 1 step, 2 step, 3 step.
1. If you hop 1 step then remaining stairs = n-1
2. If you hop 2 step then remaining stairs = n-2
3. If you hop 3 step then remaining stairs = n-3

If you hop 1 step then again you can hop 1 step, 2 step, 3 step until n equals 0.
Repeat this process and count total number of ways to reach at nth stair using step 1, 2, 3.

 */

// Program to find n-th stair using step size 1 or 2 or 3.
import java.lang.*;
//Progress => //4
public class CountStairs{

    // Driver function
    public static void main(String argc[]){
        int n = 35;
        System.out.println(findStep(n));
     //   System.out.println(findStep2(n));

    }

    public static int findStep2(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<=n; i ++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    // Returns count of ways to reach n-th stair using 1 or 2 or 3 steps.
    public static int findStep(int n) {
        if (n == 1 || n == 0)
            return 1;
        else if (n == 2)
            return 2;

        else
            return findStep(n - 3) + findStep(n - 2) + findStep(n - 1);
    }
}
