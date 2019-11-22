package com.test.ds1.array;

public class Test {

    public static void main(String[] args) {
        int arr [] = {2,5};
       // 2

        System.out.println(search(arr, 5));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        while(low <= high){
            int mid = low + (high) / 2;

            if(nums[mid] == target){
                return mid;
            } else if (target < nums[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
