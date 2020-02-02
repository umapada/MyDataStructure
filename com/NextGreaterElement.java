package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an
 * element x is the first greater element on the right side of x in array. Elements for which no greater
 * element exist, consider next greater element as -1.
 *
 * Examples:
 *
 * For any array, rightmost element always has next greater element as -1.
 * For an array which is sorted in decreasing order, all elements have next greater element as -1.
 * For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
 * Element       NGE
 *    4      -->   5
 *    5      -->   25
 *    2      -->   25
 *    25     -->   -1
 * d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.
 *
 *
 *
 *   Element        NGE
 *    13      -->    -1
 *    7       -->     12
 *    6       -->     12
 *    12      -->     -1
 */

public class NextGreaterElement {

    public static void main(String[] args) {
        int arr[] = {4,5,2,25, 23, 5};
        if(arr.length > 0){
            Map<Integer, Integer> map = getNextGreaterElement(arr);

            map.keySet().stream().forEach(x -> {
                System.out.println( x + " -> " +map.get(x));
            });
        }
    }

   static Map<Integer, Integer>  getNextGreaterElement(int[] n){
        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(n[0]);

        for(int i =1; i < n.length; i ++){
            index = i;
            while(n[i] < stack.peek() && index < n.length){
                stack.push(n[index++]);
            }

            while(!stack.empty() && n[i] > stack.peek() ){
                map.put(stack.pop(), n[i]);
            }
            stack.push(n[i]);
            if(index >= n.length){
                while (!stack.isEmpty()){
                    map.put(stack.pop(), -1);
                }
                break;
            }
        }
        if(!map.isEmpty()){
            while (!stack.isEmpty()){
                map.put(stack.pop(), -1);
            }
        }
        return map;

    }

}
