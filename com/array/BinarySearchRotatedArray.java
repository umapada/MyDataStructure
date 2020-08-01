package com.array;

/**
 * Search an element in a sorted array, which rotated n times
 */
//Progress => //4
public class BinarySearchRotatedArray {

    public static void main(String[] args) {
      //  int[] arr = {1, 1, 3,8, 8,54, 58};
      //  System.out.println(bsearch(arr, 7));
        int low = 8, high = 9;
        System.out.println(low + ((high - low) >> 1));


    }


    private static boolean bsearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[low] < nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }else if(nums[low] > nums[mid]) {
             if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }else {
                low++;
            }
        }
        return false;
    }
}
