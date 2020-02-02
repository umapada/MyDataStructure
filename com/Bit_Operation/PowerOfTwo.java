package com.Bit_Operation;


/**
 * Program to find whether a no is power of two
 * Given a positive integer, write a function to find if it is a power of two or not.
 *
 * Examples :
 *
 * Input : n = 4
 * Output : Yes
 * 22 = 4
 *
 * Input : n = 7
 * Output : No
 *
 * Input : n = 32
 * Output : Yes
 * 25 = 32
 */


public class PowerOfTwo {

    /**
     * 1. A simple method for this is to simply take the log of the number on base 2 and if you get an integer then number is power of 2.
     */

    /* Function to check if x is power of 2*/
    static boolean isPowerOfTwo(int n)
    {
        if(n==0)
            return false;

        return (int)(Math.ceil((Math.log(n) / Math.log(2)))) == (int)(Math.floor(((Math.log(n) / Math.log(2)))));
    }


    /**
     * 2. Another solution is to keep dividing the number by two, i.e, do n = n/2 iteratively. In any iteration,
     * if n%2 becomes non-zero and n is not 1 then n is not a power of 2. If n becomes 1 then it is a power of 2.
     */

    // Function to check if
    // x is power of 2
    static boolean isPowerOfTwo2(int n)
    {
        if (n == 0)
            return false;

        while (n != 1)
        {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }

    /**
     * 3. All power of two numbers have only one bit set. So count the no. of set bits and if you get 1 then number
     * is a power of 2. Please see Count set bits in an integer for counting set bits.
     *
     * 4. If we subtract a power of 2 numbers by 1 then all unset bits after the only set bit become set; and the set
     * bit become unset.
     *
     * For example for 4 ( 100) and 16(10000), we get following after subtracting 1
     * 3 –> 011
     * 15 –> 01111
     *
     * So, if a number n is a power of 2 then bitwise & of n and n-1 will be zero. We can say n is a power of 2 or not
     * based on value of n&(n-1). The expression n&(n-1) will not work when n is 0. To handle this case also, our expression will become n& (!n&(n-1)) (thanks to https://www.geeksforgeeks.org/program-to-find-whether-a-no-is-power-of-two/Mohammad for adding this case).
     * Below is the implementation of this method.
     */

    /* Method to check if x is power of 2*/
    static boolean isPowerOfTwo3 (int x)
    {
      /* First x in the below expression is
        for the case when x is 0 */
        return x!=0 && ((x&(x-1)) == 0);

    }
}
