package com.array;

/**
 * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the
 * sum of elements at higher indexes. For example, in an array A:
 *
 * Example :
 *
 * Input: A[] = {-7, 1, 5, 2, -4, 3, 0}
 * Output: 3
 * 3 is an equilibrium index, because:
 * A[0] + A[1] + A[2] =  A[4] + A[5] + A[6]
 *
 *
 *
 * Input: A[] = {1, 2, 3}
 * Output: -1
 *
 * Write a function int equilibrium(int[] arr, int n); that given a sequence arr[] of size n, returns an
 * equilibrium index (if any) or -1 if no equilibrium indexes exist.
 */


/**
 * The idea is to get the total sum of the array first. Then Iterate through the array and keep updating the left
 * sum which is initialized as zero. In the loop, we can get the right sum by subtracting the elements one by one.
 *
 * 1) Initialize leftsum  as 0
 * 2) Get the total sum of the array as sum
 * 3) Iterate through the array and for each index i, do following.
 *     a)  Update sum to get the right sum.
 *            sum = sum - arr[i]
 *        // sum is now right sum
 *     b) If leftsum is equal to sum, then return current index.
 *        // update leftsum for next iteration.
 *     c) leftsum = leftsum + arr[i]
 * 4) return -1
 * // If we come out of loop without returning then
 * // there is no equilibrium index
 */

//Progress => //4
public class EquilibriumIndexOfAnArray {


    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
        int arr_size = arr.length;
        System.out.println("First equilibrium index is " +  equilibrium(arr, arr_size));
    }

    static int equilibrium(int arr[], int n)
    {
        int sum = 0; // initialize sum of whole array
        int leftsum = 0; // initialize leftsum

        /* Find sum of the whole array */
        for (int i = 0; i < n; ++i)
            sum += arr[i];

        for (int i = 0; i < n; ++i) {
            sum -= arr[i]; // sum is now right sum for index i

            if (leftsum == sum)
                return i;

            leftsum += arr[i];
        }

        /* If no equilibrium index found, then return 0 */
        return -1;
    }


}
