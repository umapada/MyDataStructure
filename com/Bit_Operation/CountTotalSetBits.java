package com.Bit_Operation;

/**
 * Count total set bits in all numbers from 1 to n
 * Given a positive integer n, count the total number of set bits in binary representation of all numbers from 1 to n.
 * Examples:
 *
 * Input: n = 3
 * Output:  4
 *
 * Input: n = 6
 * Output: 9
 *
 * Input: n = 7
 * Output: 12
 *
 * Input: n = 8
 * Output: 13
 */


public class CountTotalSetBits {


    // Driver program
    public static void main(String[] args)
    {
        int n = 4;
        System.out.print("Total set bit count is ");
        System.out.print(getSetBitsFromOneToN(n));
    }

    /**
     * Method 1 (Simple)
     * A simple solution is to run a loop from 1 to n and sum the count of set bits in all numbers from 1 to n.
     */

    static int countSetBits( int n)
    {
        // initialize the result
        int bitCount = 0;

        for (int i = 1; i <= n; i++)
            bitCount += countSetBitsUtil(i);

        return bitCount;
    }

    // A utility function to count set bit in a number x
    static int countSetBitsUtil( int x)
    {
        if (x <= 0)
            return 0;
        return (x % 2 == 0 ? 0 : 1) + countSetBitsUtil(x / 2);
    }

    // Time Complexity: O(nLogn)

    /**
     * Method 2 (Simple and efficient than Method 1)
     * If we observe bits from rightmost side at distance i than bits get inverted after 2^i position in vertical sequence.
     * for example n = 5;
     * 0 = 0000
     * 1 = 0001
     * 2 = 0010
     * 3 = 0011
     * 4 = 0100
     * 5 = 0101
     *
     * Observe the right most bit (i = 0) the bits get flipped after (2^0 = 1)
     * Observe the 3rd rightmost bit (i = 2) the bits get flipped after (2^2 = 4)
     *
     * So, We can count bits in vertical fashion such that at i’th right most position bits will be get flipped after 2^i iteration;
     */


    static int countSetBits2(int n)
    {
        int i = 0;

        // ans store sum of set bits from 0 to n
        int ans = 0;

        // while n greater than equal to 2^i
        while ((1 << i) <= n) {

            // This k will get flipped after
            // 2^i iterations
            boolean k = false;

            // change is iterator from 2^i to 1
            int change = 1 << i;

            // This will loop from 0 to n for
            // every bit position
            for (int j = 0; j <= n; j++) {

                if (k == true)
                    ans += 1;
                else
                    ans += 0;

                if (change == 1) {

                    // When change = 1 flip the bit
                    k = !k;

                    // again set change to 2^i
                    change = 1 << i;
                }
                else {
                    change--;
                }
            }

            // increment the position
            i++;
        }

        return ans;
    }

    /**
     * Time Complexity: O(k*n)
     * where k = number of bits to represent number n
     * k <= 64
     */

    /**
     * Method 3 (Tricky)
     * If the input number is of the form 2^b -1 e.g., 1, 3, 7, 15.. etc, the number of set bits is b * 2^(b-1). This is because for all the numbers 0 to (2^b)-1, if you complement and flip the list you end up with the same list (half the bits are on, half off).
     *
     *
     * If the number does not have all set bits, then some position m is the position of leftmost set bit. The number of set bits in that position is n – (1 << m) + 1. The remaining set bits are in two parts:
     *
     * 1) The bits in the (m-1) positions down to the point where the leftmost bit becomes 0, and
     * 2) The 2^(m-1) numbers below that point, which is the closed form above.
     *
     * An easy way to look at it is to consider the number 6:
     *
     * 0|0 0
     * 0|0 1
     * 0|1 0
     * 0|1 1
     * -|--
     * 1|0 0
     * 1|0 1
     * 1|1 0
     * The leftmost set bit is in position 2 (positions are considered starting from 0). If we mask that off what
     * remains is 2 (the “1 0” in the right part of the last row.) So the number of bits in the 2nd position
     * (the lower left box) is 3 (that is, 2 + 1). The set bits from 0-3 (the upper right box above) is 2*2^(2-1) = 4.
     * The box in the lower right is the remaining bits we haven’t yet counted, and is the number of set bits for all
     * the numbers up to 2 (the value of the last entry in the lower right box) which can be figured recursively.
     */

    static int getLeftmostBit(int n)
    {
        int m = 0;
        while (n > 1)
        {
            n = n >> 1;
            m++;
        }
        return m;
    }

    /* Given the position of previous leftmost
    set bit in n (or an upper bound on
    leftmost position) returns the new
    position of leftmost set bit in n */
    static int getNextLeftmostBit(int n, int m)
    {
        int temp = 1 << m;
        while (n < temp)
        {
            temp = temp >> 1;
            m--;
        }
        return m;
    }

// The main recursive function used by countSetBits()
// Returns count of set bits present in
// all numbers from 1 to n

    static int countSetBits3(int n)
    {
        // Get the position of leftmost set
        // bit in n. This will be used as an
        // upper bound for next set bit function
        int m = getLeftmostBit(n);

        // Use the position
        return countSetBits(n, m);
    }

    static int countSetBits( int n, int m)
    {
        // Base Case: if n is 0, then set bit
        // count is 0
        if (n == 0)
            return 0;

        /* get position of next leftmost set bit */
        m = getNextLeftmostBit(n, m);

        // If n is of the form 2^x-1, i.e., if n
        // is like 1, 3, 7, 15, 31, .. etc,
        // then we are done.
        // Since positions are considered starting
        // from 0, 1 is added to m
        if (n == ((int)1 << (m + 1)) - 1)
            return (int)(m + 1) * (1 << m);

        // update n for next recursive call
        n = n - (1 << m);
        return (n + 1) + countSetBits(n) + m * (1 << (m - 1));
    }

    /**
     * Time Complexity: O(Logn). From the first look at the implementation, time complexity looks more. But if we take
     * a closer look, statements inside while loop of getNextLeftmostBit() are executed for all 0 bits in n.
     * And the number of times recursion is executed is less than or equal to set bits in n. In other words,
     * if the control goes inside while loop of getNextLeftmostBit(), then it skips those many bits in recursion.
     */


    /**
     * A simple solution , using the fact that for the ith least significant bit, answer will be
     *
     * (N/2^i)*2^(i-1)+ X
     * where
     *
     * X = N%(2^i)-(2^(i-1)-1)
     * iff
     *
     * N%(2^i)>=(2^(i-1)-1)
     */

    static int getSetBitsFromOneToN(int N){
        int two = 2,ans = 0;
        int n = N;
        while(n != 0){
            ans += (N/two)*(two>>1);
            if((N&(two-1)) > (two>>1)-1) ans += (N&(two-1)) - (two>>1)+1;
            two <<= 1;
            n >>= 1;
        }
        return ans;
    }
}
