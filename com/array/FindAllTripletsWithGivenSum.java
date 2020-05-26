package com.array;
//Find all triplets with a given sum


/*
Since the best case for finding pairs was O(n log n) for sorting and then O(n) for finding pairs, it
follows that the order for triplets would be greater than or equal to that.

Taking liberty due to this, let us first sort the array.

Now for each number in the sorted array, we can find a pair whose sum is S-arr[k]

Since finding pairs for a given sum is O(n) in sorted array, the whole operation becomes O(n log n ) + O(n2)

Which is equal to O(n2)
 */

import java.util.*;

public class FindAllTripletsWithGivenSum {

    public static void main(String[] args) {
        int nums [] = { 1, 3,4 , 5, 2, 7, 8};
        int target = 10;
        findTriplets(nums, target);
    }

    static void findTriplets(int [] nums, int target){
        Arrays.sort(nums);

        for(int i=0; i < nums.length; i++){
            int start = i+1;
            int end = nums.length-1;
            int x = nums[i];
            while(start < end){
                if(x + nums[start] + nums[end] == target){
                    System.out.println(x + " " + nums[start] + " " + nums[end]);
                    start++;
                    end --;
                }else if (x + nums[start] + nums[end] < target){
                    start++;
                }else{
                    end--;
                }
            }
        }
    }
}
