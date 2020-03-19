package extra; /**
 * Calculate sum of all numbers present in a string
 * Given a string containing alphanumeric characters, calculate sum of all numbers present in the string.
 *
 * Examples:
 *
 * Input:  1abc23
 * Output: 24
 *
 * Input:  geeks4geeks
 * Output: 4
 *
 * Input:  1abc2x30yz67
 * Output: 100
 *
 * Input:  123abc
 * Output: 123
 */

/**
 * The only tricky part in this question is that multiple consecutive digits are considered as one number.
 *
 * The idea is very simple. We scan each character of the input string and if a number is formed by consecutive
 * characters of the string, we increment the result by that amount.
 */


// Java program to calculate sum of all numbers present
// in a string containing alphanumeric characters
class SumOfNumbersInString
{

    // Function to calculate sum of all numbers present
    // in a string containing alphanumeric characters
    static int findSum(String str)
    {
        // A temporary string
        String temp = "";

        // holds sum of all numbers present in the string
        int sum = 0;

        // read each character in input string
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);

            // if current character is a digit
            if (Character.isDigit(ch))
                temp += ch;

                // if current character is an alphabet
            else
            {
                // increment sum by number found earlier
                // (if any)
                sum += Integer.parseInt(temp);

                // reset temporary string to empty
                temp = "0";
            }
        }

        // atoi(temp.c_str()) takes care of trailing
        // numbers
        return sum + Integer.parseInt(temp);
    }

    // Driver code
    public static void main (String[] args)
    {

        // input alphanumeric string
        String str = "12abc20yz68";

        System.out.println(findSum(str));
    }
}

// This code is contributed by AnkitRai01
