package com; /**
 * Number of occurrences of 2 as a digit in numbers from 0 to n
 * Count the number of 2s as digit in all numbers from 0 to n.
 *
 * Examples :
 *
 * Input : 22
 * Output : 6
 * Explanation: Total 2s that appear as digit
 *              from 0 to 22 are (2, 12, 20,
 *              21, 22);
 *
 * Input : 100
 * Output : 20
 * Explanation: total 2's comes between 0 to 100
 * are (2, 12, 20, 21, 22..29, 32, 42, 52, 62, 72,
 * 82, 92);
 */


/**
 * The idea is to look at the problem digit by digit. Picture a sequence of numbers:
 *
 * 0  1  2  3  4  5  6  7  8  9
 * 10 11 12 13 14 15 16 17 18 19
 * 20 21 22 23 24 25 26 27 28 29
 * ......
 * 110 111 112 113 114 115 116 117 118 119
 * We know that roughly one tenth of the time, the last digit will be a 2 since it happens once in any sequence of ten
 * numbers. In fact, any digit is a 2 roughly one tenth of the time.
 *
 * We say “roughly” because there are (very common) boundary conditions. For example, between 1 and 100, the 10’s digit
 * is a 2 exactly 1/10th of the time. However, between 1 and 37, the 10’s digit is a 2 much more than 1/10th of the time.
 *
 * We can work out what exactly the ratio is by looking at the three cases individually: digit 2.
 *
 * Case digits < 2
 * Consider the value x = 61523 and digit at index d = 3 (here indexes are considered from right and rightmost index is 0).
 * We observe that x[d] = 1. There are 2s at the 3rd digit in the ranges 2000 – 2999, 12000 – 12999, 22000 – 22999,
 * 32000 32999, 42000 – 42999, and 52000 – 52999. So there are 6000 2’s total in the 3rd digit. This is the same amount as
 * if we were just counting all the 2s in the 3rd digit between 1 and 60000.
 *
 * In other words, we can round down to the nearest 10d+1, and then divide by 10, to compute the number of 2s in the d-th digit.
 *
 *
 * if x[d) < 2: count2sinRangeAtDigit(x, d) =
 *   Compute y = round down to nearest 10d+1
 *   return y/10
 * Case digit > 2
 * Now, let’s look at the case where d-th digit (from right) of x is greater than 2 (x[d] > 2). We can apply almost the
 * exact same logic to see that there are the same number of 2s in the 3rd digit in the range 0 – 63525 as there as in
 * the range 0 – 70000. So, rather than rounding down, we round up.
 *
 * if x[d) > 2: count2sinRangeAtDigit(x, d) =
 *   Compute y = round down to nearest 10d+1
 *   return y / 10
 * Case digit = 2
 * The final case may be the trickiest, but it follows from the earlier logic. Consider x = 62523 and d = 3. We know that
 * there are the same ranges of 2s from before (that is, the ranges 2000 – 2999, 12000 – 12999, … , 52000 – 52999).
 * How many appear in the 3rd digit in the final, partial range from 62000 – 62523? Well, that should be pretty easy.
 * It’s just 524 (62000, 62001, … , 62523).
 *
 * if x[d] = 2: count2sinRangeAtDigit(x, d) =
 *    Compute y = round down to nearest 10d+1
 *    Compute z = right side of x (i.e., x%  10d)
 *    return y/10 + z + 1
 * Now, all we need is to iterate through each digit in the number. Implementing this code is reasonably straightforward.
 */




// Java program to count 2s from 0 to n
class NumberOfOccurrencesOf2
{


    // Driver Code
    public static void main(String[] args)
    {
        System.out.println(numberOf2sinRange(20));
        System.out.println(numberOf2sinRange(100));
    }


    // Counts the number of 2s
    // in a number at d-th digit
    static int count2sinRangeAtDigit(int number, int d)
    {
        int powerOf10 = (int) Math.pow(10, d);
        int nextPowerOf10 = powerOf10 * 10;
        int right = number % powerOf10;

        int roundDown = number - number % nextPowerOf10;
        int roundup = roundDown + nextPowerOf10;

        int digit = (number / powerOf10) % 10;

        // if the digit in spot digit is
        if (digit < 2)
        {
            return roundDown / 10;
        }

        if (digit == 2)
        {
            return roundDown / 10 + right + 1;
        }
        return roundup / 10;
    }

    // Counts the number of '2' digits between 0 and n
    static int numberOf2sinRange(int number)
    {
        // Convert integer to String
        // to find its length
        String convert;
        convert = String.valueOf(number);
        String s = convert;
        int len = s.length();

        // Traverse every digit and
        // count for every digit
        int count = 0;
        for (int digit = 0; digit < len; digit++)
        {
            count += count2sinRangeAtDigit(number, digit);
        }

        return count;
    }


}

// This code is contributed by PrinciRaj1992
