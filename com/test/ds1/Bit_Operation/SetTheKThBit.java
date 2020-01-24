package com.test.ds1.Bit_Operation;

/**
 * Set the K-th bit of a given number
 * Given a number n and a value k. From the right, set the kth bit in the binary representation of n.
 * The position of LSB(or last bit) is 0, second last bit is 1 and so on. Also, 0 <= k < x, where x is the number
 * of bits in the binary representation of n.
 *
 * Examples:
 *
 * Input : n = 10, k = 2
 * Output : 14
 * (10)10 = (1010)2
 * Now, set the 2nd bit from right.
 * (14)10 = (1110)2
 * 2nd bit has been set.
 *
 * Input : n = 15, k = 3
 * Output : 15
 * 3rd bit of 15 is already set.
 */


public class SetTheKThBit {

    /**
     * To set any bit we use bitwise OR | operator. As we already know bitwise OR | operator evaluates each bit of the
     * result to 1 if any of the operand’s corresponding bit is set (1). In-order to set kth bit of a number we need to
     * shift 1 k times to its left and then perform bitwise OR operation with the number and result of left shift
     * performed just before.
     */

    static int setKthBit(int n, int k)
    {
        // kth bit of n is being set by this operation
        return ((1 << k) | n);
    }

    // Driver code
    public static void main(String arg[])
    {
        int n = 10, k = 2;
        System.out.print("Kth bit set number = " +
                setKthBit(n, k));
    }


}
