package com.test.ds1.median;

import java.util.Arrays;

/*
Use merge procedure of merge sort. Keep track of count while comparing elements of two arrays. If count becomes n(For 2n elements),
we have reached the median. Take the average of the elements at indexes n-1 and n in the merged array.
 */
public class MedianOfTwoSortedArray {

    // O(n)
    // function to calculate median
    static int getMedian1(int ar1[], int ar2[], int n)
    {
        int i = 0;
        int j = 0;
        int count;
        int m1 = -1, m2 = -1;

        /* Since there are 2n elements, median will
           be average of elements at index n-1 and
           n in the array obtained after merging ar1
           and ar2 */
        for (count = 0; count <= n; count++)
        {
            /* Below is to handle case where all
              elements of ar1[] are smaller than
              smallest(or first) element of ar2[] */
            if (i == n)
            {
                m1 = m2;
                m2 = ar2[0];
                break;
            }

            /* Below is to handle case where all
               elements of ar2[] are smaller than
               smallest(or first) element of ar1[] */
            else if (j == n)
            {
                m1 = m2;
                m2 = ar1[0];
                break;
            }

            if (ar1[i] < ar2[j])
            {
                /* Store the prev median */
                m1 = m2;
                m2 = ar1[i];
                i++;
            }
            else
            {
                /* Store the prev median */
                m1 = m2;
                m2 = ar2[j];
                j++;
            }
        }

        return (m1 + m2)/2;
    }


    // O(log(n))

/*
1) Calculate the medians m1 and m2 of the input arrays ar1[] and ar2[] respectively.

2) If m1 and m2 both are equal then we are done. return m1 (or m2)

3) If m1 is greater than m2, then median is present in one    of the below two subarrays.
	a) From first element of ar1 to m1 (ar1[0...|_n/2_|])
	b) From m2 to last element of ar2  (ar2[|_n/2_|...n-1])

4) If m2 is greater than m1, then median is present in one of the below two subarrays.
	a) From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
	b) From first element of ar2 to m2 (ar2[0...|_n/2_|])

5) Repeat the above process until size of both the subarrays becomes 2.


*/

//@Info Below function may not work for changed logic at line 123-124, 131-132


    /* This function returns median
    of ar1[] and ar2[].
    Assumptions in this function:
        Both ar1[] and ar2[] are
        sorted arrays
        Both have n elements */
    static int getMedian(int ar1[], int ar2[], int n)
    {
    /* return -1 for
    invalid input */
        if (n <= 0)
            return -1;
        if (n == 1)
            return (ar1[0] + ar2[0]) / 2;
        if (n == 2)
            return (Math.max(ar1[0], ar2[0]) + Math.min(ar1[1], ar2[1])) / 2;

    /* get the median of
    the first array */
        int m1 = median(ar1, n);

    /* get the median of
    the second array */
        int m2 = median(ar2, n);

    /* If medians are equal then
    return either m1 or m2 */
        if (m1 == m2)
            return m1;

    /* if m1 < m2 then median must
    exist in ar1[m1....] and
                ar2[....m2] */
        if (m1 < m2)
        {
            if (n % 2 == 0)
                return getMedian(Arrays.copyOfRange(ar1,n / 2 - 1,n-1), Arrays.copyOfRange(ar2,n - n / 2 + 1 ,n-1), n / 2);
            return getMedian(Arrays.copyOfRange(ar1,n / 2 ,n), Arrays.copyOfRange(ar2, n - n / 2, n-1), n/2-1);
        }
//Arrays.copyOfRange(ar2,n/2,n -1)
    /* if m1 > m2 then median must
    exist in ar1[....m1] and
                ar2[m2...] */
        if (n % 2 == 0)
            return getMedian(Arrays.copyOfRange(ar2,n - n / 2 + 1 ,n-1), Arrays.copyOfRange(ar1,0 ,n / 2 + 1), n / 2);
        return getMedian(Arrays.copyOfRange(ar2,n/2,n -1), Arrays.copyOfRange(ar1,0 ,n / 2), n / 2);
    }

    /* Function to get median
    of a sorted array */
    static int median(int arr[], int n)
    {
        if (n % 2 == 0)
            return (arr[n / 2] + arr[n / 2 - 1]) / 2;
        else
            return arr[n / 2];
    }

}
