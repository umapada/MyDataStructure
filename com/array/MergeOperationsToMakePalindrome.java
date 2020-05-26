package com.array;

/**
 * Find minimum number of merge operations to make an array palindrome
 * Given an array of positive integers. We need to make the given array a ‘Palindrome’. Only allowed operation on
 * array is merge. Merging two adjacent elements means replacing them with their sum. The task is to find minimum
 * number of merge operations required to make given array a ‘Palindrome’.
 *
 * To make an array a palindromic we can simply apply merging operations n-1 times where n is the size of array
 * (Note a single element array is alway palindrome similar to single character string). In that case, size of array
 * will be reduced to 1. But in this problem we are asked to do it in minimum number of operations.
 *
 * Example :
 *
 * Input : arr[] = {15, 4, 15}
 * Output : 0
 * Array is already a palindrome. So we
 * do not need any merge operation.
 *
 * Input : arr[] = {1, 4, 5, 1}
 * Output : 1
 * We can make given array palindrome with
 * minimum one merging (merging 4 and 5 to
 * make 9)
 *
 * Input : arr[] = {11, 14, 15, 99}
 * Output : 3
 * We need to merge all elements to make
 * a palindrome.
 * Expected time complexity is O(n).
 *
 *
 *
 * Let f(i, j) be minimum merging operations to make subarray arr[i..j] a palindrome. If i == j answer is 0.
 * We start i from 0 and j from n-1.
 *
 * If arr[i] == arr[j], then there is no need to do any merging operations at index i or index j. Our answer in this case
 * will be f(i+1, j-1). Else, we need to do merging operations. Following cases arise.
 * If arr[i] > arr[j], then we should do merging operation at index j. We merge index j-1 and j, and update
 * arr[j-1] = arr[j-1] + arr[j]. Our answer in this case will be 1 + f(i, j-1).
 * For the case when arr[i] < arr[j], update arr[i+1] = arr[i+1] + arr[i]. Our answer in this case will be 1 + f(i+1, j).
 * Our answer will be f(0, n-1), where n is size of array arr[].
 * Therefore this problem can be solved iteratively using two pointers (first pointer pointing to start of the array
 * and second pointer pointing to last element of the array) method and keeping count of total merging operations done till now.
 */


// Java program to find number of operations to make an array palindrome
//Progress => //5
class MergeOperationsToMakePalindrome
{
    // Driver method to test the above function
    public static void main(String[] args)
    {
        int arr[] = new int[]{2, 4, 5, 9, 1} ;
        System.out.println("Count of minimum operations is "+ findMinOps(arr, arr.length));
    }
    // Returns minimum number of count operations required to make arr[] palindrome
    static int findMinOps(int[] arr, int n)
    {
        int ans = 0; // Initialize result
        // Start from two corners
        int i = 0;
        int j = n-1;
        while ( i<=j)
        {
            // If corner elements are same, problem reduces arr[i+1..j-1]
            if (arr[i] == arr[j])
            {
                i++;
                j--;
            }
            // If left element is greater, then we merge right two elements
            else if (arr[i] > arr[j])
            {
                // need to merge from tail.
                j--;
                arr[j] += arr[j+1] ;
                ans++;
            }

            // Else we merge left two elements
            else
            {
                i++;
                arr[i] += arr[i-1];
                ans++;
            }
        }

        return ans;
    }


}
