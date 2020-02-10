package com.array;
//Progress => //6
public class RemoveDuplicateSortedArray {

    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        int length = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[length] != nums[i]){
                nums[++length] = nums[i];
            }
        }
        return length;
    }

}
