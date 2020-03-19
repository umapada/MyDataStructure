package com.Bit_Operation;

public class UniqueCharInString {
//https://stackoverflow.com/questions/9141830/explain-the-use-of-a-bit-vector-for-determining-if-all-characters-are-unique

    public static void main(String[] args) {

        System.out.println(isUniqueChars("abcd"));
    }

    public static boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }
}


/*

I have a sneaking suspicion you got this code from the same book I'm reading...The code itself here isn't nearly as cryptic as the the operators- |=, &, and << which aren't normally used by us layman- the author didn't bother taking the extra time out in explaining the process nor what the actual mechanics involved here are. I was content with the previous answer on this thread in the beginning but only on an abstract level. I came back to it because I felt there needed to be a more concrete explanation- the lack of one always leaves me with an uneasy feeling.

This operator << is a left bitwise shifter it takes the binary representation of that number or operand and shifts it over however many places specified by the operand or number on the right like in decimal numbers only in binaries. We are multiplying by base 2-when we move up however many places not base 10- so the number on the right is the exponent and the number on the left is a base multiple of 2.

This operator |= take the operand on the left and or's it with the operand on the right- and this one -'&'and's the bits of both operands to left and right of it.

So what we have here is a hash table which is being stored in a 32 bit binary number every time the checker gets or'd ( checker |= (1 << val)) with the designated binary value of a letter its corresponding bit it is being set to true. The character's value is and'd with the checker (checker & (1 << val)) > 0)- if it is greater than 0 we know we have a dupe- because two identical bits set to true and'd together will return true or '1''.

There are 26 binary places each of which corresponds to a lowercase letter-the author did say to assume the string only contains lowercase letters- and this is because we only have 6 more (in 32 bit integer) places left to consume- and than we get a collision

00000000000000000000000000000001 a 2^0

00000000000000000000000000000010 b 2^1

00000000000000000000000000000100 c 2^2

00000000000000000000000000001000 d 2^3

00000000000000000000000000010000 e 2^4

00000000000000000000000000100000 f 2^5

00000000000000000000000001000000 g 2^6

00000000000000000000000010000000 h 2^7

00000000000000000000000100000000 i 2^8

00000000000000000000001000000000 j 2^9

00000000000000000000010000000000 k 2^10

00000000000000000000100000000000 l 2^11

00000000000000000001000000000000 m 2^12

00000000000000000010000000000000 n 2^13

00000000000000000100000000000000 o 2^14

00000000000000001000000000000000 p 2^15

00000000000000010000000000000000 q 2^16

00000000000000100000000000000000 r 2^17

00000000000001000000000000000000 s 2^18

00000000000010000000000000000000 t 2^19

00000000000100000000000000000000 u 2^20

00000000001000000000000000000000 v 2^21

00000000010000000000000000000000 w 2^22

00000000100000000000000000000000 x 2^23

00000001000000000000000000000000 y 2^24

00000010000000000000000000000000 z 2^25
So, for an input string 'azya', as we move step by step

string 'a'

a      =00000000000000000000000000000001
checker=00000000000000000000000000000000

checker='a' or checker;
// checker now becomes = 00000000000000000000000000000001
checker=00000000000000000000000000000001

a and checker=0 no dupes condition
string 'az'

checker=00000000000000000000000000000001
z      =00000010000000000000000000000000

z and checker=0 no dupes

checker=z or checker;
// checker now becomes 00000010000000000000000000000001
string 'azy'

checker= 00000010000000000000000000000001
y      = 00000001000000000000000000000000

checker and y=0 no dupes condition

checker= checker or y;
// checker now becomes = 00000011000000000000000000000001
string 'azya'

checker= 00000011000000000000000000000001
a      = 00000000000000000000000000000001

a and checker=1 we have a dupe
Now, it declares a duplicate

 */