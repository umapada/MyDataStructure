package com.stackqueue.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Given a string with repeated characters, the task is to rearrange characters in a string so that no two
 * adjacent characters are same.
 *
 * Note : It may be assumed that the string has only lowercase English alphabets.
 *
 * Examples:
 *
 *
 *
 * Input: aaabc
 * Output: abaca
 *
 * Input: aaabb
 * Output: ababa
 *
 * Input: aa
 * Output: Not Possible
 *
 * Input: aaaabc
 * Output: Not Possible
 */


class Ele implements Comparable<Ele>{
    char chr;
    int count;
    Ele(char chr, int count){
        this.chr = chr;
        this.count = count;
    }
    @Override
    public int compareTo(Ele o) {
        return o.count - this.count;
    }
}


public class RearrangeCharacters {


    static int MAX_CHAR = 26;

    // Function to rearrange character of a string
    // so that no char repeat twice
    static void rearrangeString(String str) {
        int n = str.length();

        // Store frequencies of all characters in string
        int[] count = new int[MAX_CHAR];

        for (int i = 0; i < n; i++)
            count[str.charAt(i) - 'a']++;

        // Insert all characters with their frequencies
        // into a priority_queue
        AtomicInteger index = new AtomicInteger(-1);
        Queue<Ele> pq = new PriorityQueue<>();
        Arrays.stream(count).forEach(x -> {
            index.getAndIncrement();
            if (x != 0) {
               // System.out.println(x + " Times " + (char) ('a' + index.intValue()));
                Ele ele = new Ele((char) ('a' + index.intValue()), x);
                pq.add(ele);
            }
        });
        // 'str' that will store resultant value
        str = "";
        // work as the previous visited element
        // initial previous element be. ( '#' and
        // it's frequency '-1' )
        Ele prev = new Ele('#', -1);
        // traverse queue
        while (pq.size() != 0) {
            // pop top element from queue and add it
            // to string.
            Ele k = pq.poll();

            str = str + k.chr;
            // decrease frequency by 'one'
            (k.count)--;
            // If frequency of previous character is less
            // than zero that means it is useless, we
            // need not to push it
            if (prev.count > 0)
                pq.add(prev);
            // make current character as the previous 'char'

            prev = k;
        }
        // If length of the resultant string and original
        // string is not same then string is not valid

        if (n != str.length())
            System.out.println(" Not Possible ");
        else
            System.out.println(str);
    }

    // Driver program to test above function
    public static void main(String args[]) {
        String str = "bbbaz";
        rearrangeString(str);
    }
}