package com.test.ds1.array;
/*

Given an array arr[], the task is to make all the array elements equal with the given operation.
In a single operation, any element of the array can be either multiplied by 2 or by 3. If its
possible to make all the array elements equal with the given operation then print Yes else print No.

Examples:

Input: arr[] = {50, 75, 100}
Output: Yes
{50 * 2 * 3, 75 * 2 * 2, 100 * 3} = {300, 300, 300}

Input: arr[] = {10, 14}
Output: No

 */
public class MakeAllNumbersArrayEqual {

    // Function that returns true if all the array elements can be made equal with the given operation
    static boolean EqualNumbers(int a[], int n)
    {
        for (int i = 0; i < n; i++)
        {

            // Divide number by 2
            while (a[i] % 2 == 0)
            {
                a[i] /= 2;
            }

            // Divide number by 3
            while (a[i] % 3 == 0)
            {
                a[i] /= 3;
            }
        }

        // Remaining numbers
        for (int i = 1; i < n; i++)
        {
            if (a[i] != a[0])
            {
                return false;
            }
        }

        return true;
    }

    // Driver code
    public static void main(String[] args)
    {
        int a[] = {50, 75, 150};

        int n = a.length;

        if (EqualNumbers(a, n))
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }
}



