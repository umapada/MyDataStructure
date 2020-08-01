package extra;

/*

Given a number, find its corresponding Roman numeral.
Examples:

Input : 9
Output : IX

Input : 40
Output : XL

Input :  1904
Output : MCMIV
Following is the list of Roman symbols which include subtractive cases also:

SYMBOL       VALUE
I             1
IV            4
V             5
IX            9
X             10
XL            40
L             50
XC            90
C             100
CD            400
D             500
CM            900
M             1000

 */

/*

Algorithm to convert decimal number to Roman Numeral
Compare given number with base values in the order 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1. Base value which is just smaller or equal to the given number will be the initial base value (largest base value) .Divide the number by its largest base value, the corresponding base symbol will be repeated quotient times, the remainder will then become the number for future division and repetitions.The process will be repeated until the number becomes zero.

Example to demonstrate above algorithm:

Convert 3549 to its Roman Numerals
Output:

MMMDXLIX
Explanation:

Step 1
Initially number = 3549
Since 3549 >= 1000 ; largest base value will be 1000 initially.
Divide 3549/1000. Quotient = 3, Remainder =549. The corresponding symbol M will be repeated thrice.
Step 2

Now, number = 549
1000 > 549 >= 500 ; largest base value will be 500.
Divide 549/500. Quotient = 1, Remainder =49. The corresponding symbol D will be repeated once.
Step 3

Now, number = 49
50 > 49 >= 40 ; largest base value is 40.
Divide 49/40. Quotient = 1, Remainder = 9. The corresponding symbol XL will be repeated once.
Step 4

Now, number = 9
10> 9 >= 9 ; largest base value is 9.
Divide 9/9. Quotient = 1, Remainder = 0. The corresponding symbol IX will be repeated once.
Step 5


Finally number becomes 0, algorithm stops here.
Output obtained MMMDXLIX.

 */

class DecimalToRoman {

    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static String printRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
