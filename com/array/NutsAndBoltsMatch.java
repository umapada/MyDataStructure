package com.array;

/*

Given a set of n nuts of different sizes and n bolts of different sizes. There is a one-one mapping between nuts and
bolts. Match nuts and bolts efficiently.
Constraint: Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be
compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.

Examples:

Input : nuts[] = {'@', '#', '$', '%', '^', '&'}
        bolts[] = {'$', '%', '&', '^', '@', '#'}
Output : Matched nuts and bolts are-
        $ % & ^ @ #
        $ % & ^ @ #
Other way of asking this problem is, given a box with locks and keys where one lock can be opened by one key in
the box. We need to match the pair.

 */


/*

In this post, hashmap based approach is discussed.

Travese the nuts array and create a hashmap
Traverse the bolts array and search for it in hashmap.
If it is found in the hashmap of nuts than this means bolts exist for that nut.

 */

import java.util.HashMap;
import java.util.Map;

public class NutsAndBoltsMatch {


    public static void main(String[] args)
    {
        // Nuts and bolts are represented as array of characters
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};

        // Method based on quick sort which matches nuts and bolts
        matchPairs(nuts, bolts);

        System.out.println("Matched nuts and bolts are : ");
        printArray(nuts);
        System.out.println();
        printArray(bolts);
    }

    // Method to print the array
    private static void printArray(char[] arr) {
        for (char ch : arr){
            System.out.print(ch + " ");
        }
     //   System.out.print("n");
    }

    // Method which works just like quick sort
    private static void matchPairs(char[] nuts, char[] bolts) {

        Map<Character,Integer> nutMap = new HashMap<>();

        for(int i=0; i < nuts.length; i ++){
                nutMap.put(nuts[i], i);
        }

        for(int i=0; i < bolts.length ; i ++){
            if(nutMap.containsKey(bolts[i])){
                nuts[i] = bolts[i];
            }
        }

    }

}