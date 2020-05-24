package com.Bit_Operation;
/*
Swap bits at position i and j

Swap the bits at position i and j only if they are different.

If they are same, then swap would not make any difference.
 */
public class SwapBitsAtPositionIAndJ {

    int swapBits(int x, int i, int j){
        int lo = ((x>>i) & 1);
        int hi = ((x>>j) & 1);
        if((lo ^ hi )!= 0){
           x ^= ((1<<i) | (1<<j));
        }
        return x;
    }
}
