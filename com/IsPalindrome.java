package com;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
        int i = Integer.MAX_VALUE;
        System.out.println(Integer.MAX_VALUE);

        System.out.println(reverse(i));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        if(x == reverse(x)){
            return true;
        }else {
            return false;
        }
    }

    static int reverse(int x){
        int rev = 0;
        while (x != 0){
            rev = x % 10 + rev * 10;
            x = x /10;
        }
        return rev;
    }

}
