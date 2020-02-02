package com.slidingwindow;

/*

You are working on developing visual recognition software for Cashier less Shop. As input to your software,
another algorithm has identified shoppers(labeled with letters) that appear in a video stream in the sequence
that they appear.

Write a function which will partition the given sequence of shoppers into minimal sub-sequences, where no
shopper appears in more than one sub-sequence. The output of your function will be a list containing the
length of each sub-sequence.

Input:- The input to the function/method consists of an argument - inputList, a list of characters representing
the sequence of shoppers.

Output:- Return a list of integers representing the length of each sub-sequence, in the order in which it appears
in the given sequence of shoppers.

Example 1:
InputList: [a,b,c]
Output: [1,1,1]
Explain: Because there are no recurring shoppers in the video stream, all shoppers can be in the minimal
length 1 sub-sequence.

Example 2:
InputList: [a,b,c,a]
Output: [4]
Explain: Because shoppers appear more than once, everything between the first and last appearance of shopper 'a'
must be in the same list.

Example 3:
inputlist: [a,b,a,b,c,b,a,c,a,d,e,f,e,g,d,e,h,i,j,h,k,l,i,j]
output: [9,7,8]
Explain: The correct partitioning is:
a,b,a,b,c,b,a,c,a,/d,e,f,e,g,d,e,/h,i,j,h,k,l,i,j
To ensure that no label appears in more than one subsequence, subsequences are as small as possible, and subsequences partition the sequence.
The length of these subsequences are 9, 7 and 8.
 */

import java.util.ArrayList;
import java.util.List;

public class Amazon_Go_Grocery {
    public static void main(String[] args) {


        List<Character> inputList = new ArrayList<>();
        inputList.add('a');
        inputList.add('b');
        inputList.add('c');
        inputList.add('a');
        inputList.add('d');


//        inputList.add('a');
//        inputList.add('b');
//        inputList.add('a');
//        inputList.add('b');
//        inputList.add('c');
//        inputList.add('b');
//        inputList.add('a');
//        inputList.add('c');
//        inputList.add('a');
//        inputList.add('d');
//        inputList.add('e');
//        inputList.add('f');
//        inputList.add('e');
//        inputList.add('g');
//        inputList.add('d');
//        inputList.add('e');
//        inputList.add('h');
//        inputList.add('i');
//        inputList.add('j');
//        inputList.add('h');
//        inputList.add('k');
//        inputList.add('l');
//        inputList.add('i');
//        inputList.add('j');

        System.out.println(lengthSubsequenceShoppers(inputList));
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<Integer> lengthSubsequenceShoppers(List<Character> inputList) {
        // WRITE YOUR CODE HERE

        List<Integer> returnResult = new ArrayList<Integer>();

        if (inputList == null || inputList.size() == 0)
            return null;
        // Convert List to String
        String inputString = inputList.stream().map(e -> e.toString()).reduce((acc, e) -> acc + e).get();
        //inputList = [a,b,a,b,c,b,a,c,a,d,e,f,e,g,d,e,h,i,j,h,k,l,i,j]


        int startSequence = 0;
        int endSequence = 0;
        // Convert String to Char array
        char[] stringArray = inputString.toCharArray();

        //Continue until start sequence less than string length
        while (startSequence < stringArray.length) {
            endSequence = inputString.lastIndexOf(stringArray[startSequence]);
            if (startSequence == endSequence) {
                returnResult.add(1);
                startSequence++;
            } else {

                for (int j = startSequence + 1; j < endSequence; j++) {

                    if (inputString.lastIndexOf(stringArray[j]) > endSequence)
                        endSequence = inputString.lastIndexOf(stringArray[j]);
                }
                returnResult.add(endSequence - startSequence + 1);
                startSequence = endSequence + 1;
            }

        }
        // Integer[] resultArr = new Integer[result.size()];
        // List<Integer> ret = new ArrayList<>(Arrays.asList(resultArr));

        // resultArr = result.toArray(resultArr);
        return returnResult;
    }

    // METHOD SIGNATURE ENDS
}
