package com;

/*

A number is called happy if it leads to 1 after a sequence of steps where in each step
number is replaced by sum of squares of its digit that is if we start with Happy Number
and keep replacing it with digits square sum, we reach 1.
Examples :

Input: n = 19
Output: True
19 is Happy Number,
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
As we reached to 1, 19 is a Happy Number.

Input: n = 20
Output: False

 */

/*

A number will not be a Happy Number when it makes a loop in its sequence that is it touches a
number in sequence which already been touched. So to check whether a number is happy or not,
we can keep a set, if same number occurs again we flag result as not happy.

 */

/*
int isHappyNumber(int n)
{
    set<int> st;
    while (1)
    {
        n = numSquareSum(n);
        if (n == 1)
            return true;
        if (st.find(n) != st.end())
            return false;
        st.insert(n);
    }
}

 */


/*
We can solve this problem without using extra space and that technique can be used in some other similar
problem also. If we treat every number as a node and replacement by square sum digit as a link, then this
problem is same as finding a loop in a linklist :

So as proposed solution from above link, we will keep two number slow and fast both initialize from given
number, slow is replaced one step at a time and fast is replaced two steps at a time. If they meet at 1,
then the given number is Happy Number otherwise not.

 */


// Another approach is to store the number everytime in a Set. If the number repeats, its not happy number.

public class HappyNumber {

    // Utility method to return sum of square of digit of n
    static int numSquareSum(int n)
    {
        int squareSum = 0;
        while (n!= 0)
        {
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return squareSum;
    }


    //  method return true if n is Happy number
    static boolean isHappynumber(int n)
    {
        int slow, fast;

        //  initialize slow and fast by n
        slow = fast = n;
        do
        {
            //  move slow number by one iteration
            slow = numSquareSum(slow);

            //  move fast number by two iteration
            fast = numSquareSum(numSquareSum(fast));

        }
        while (slow != fast);

        //  if both number meet at 1, then return true
        return (slow == 1);
    }
}
