package extra;

/*

Given a Roman numeral, the task is to find its corresponding decimal value.

Example :

Input: IX
Output: 9



Input: XL
Output: 40

Input: MCMIV
Output: 1904
M is a thousand, CM is nine hundred
and IV is four

 */

/*

Roman numerals are based on below symbols.

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
A number in Roman Numerals is a string of these symbols written in descending order(e.g. M’s first, followed by D’s,
etc.). However, in a few specific cases, to avoid four characters being repeated in succession (such as IIII or XXXX),
subtractive notation is often used as follows:

I placed before V or X indicates one less, so four is IV (one less than 5) and 9 is IX (one less than 10).
X placed before L or C indicates ten less, so forty is XL (10 less than 50) and 90 is XC (ten less than a hundred).
C placed before D or M indicates a hundred less, so four hundred is CD (a hundred less than five hundred) and nine
hundred is CM (a hundred less than a thousand).
Algorithm to convert Roman Numerals to Integer Number :

Split the Roman Numeral string into Roman Symbols (character).
Convert each symbol of Roman Numerals into the value it represents.
Take symbol one by one from starting from index 0:
If current value of symbol is greater than or equal to the value of next symbol, then add this value to the running total.
else subtract this value by adding the value of next symbol to the running total.

 */

public class RomanToDecimal
{
    //count every Symbol and add its value to the sum,
    // and minus the extra part of special cases.
    public int romanToDecimal(String s) {
        int sum=0;
        if(s.indexOf ("IV")!=-1) {sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}
        char c[]=s.toCharArray();
        for(int count=0;count < s.length();count++){
            if(c[count]=='M') sum+=1000;
            else if(c[count]=='D') sum+=500;
            else if(c[count]=='C') sum+=100;
            else if(c[count]=='L') sum+=50;
            else if(c[count]=='X') sum+=10;
            else if(c[count]=='V') sum+=5;
            else if(c[count]=='I') sum+=1;
        }
        return sum;
    }
    // Driver method
    public static void main(String args[])
    {
        RomanToDecimal ob = new RomanToDecimal();
        // Considering inputs given are valid
        String str = "MCMIV";
        System.out.println("Integer form of Roman Numeral" + " is " + ob.romanToDecimal(str));
    }
}
