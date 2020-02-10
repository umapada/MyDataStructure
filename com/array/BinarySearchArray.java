package com.array;
//Progress => //4
public class BinarySearchArray {

    public static void main(String[] args) {
        int [] arr = {2, 4, 6, 8, 12};
        int target = 7;
        System.out.println(bs(arr, target, 0, arr.length -1 ));
    }

    private static boolean bs(int[] arr, int target, int start, int end){
       boolean found = false;

           if(end >= start){
               int mid = start + ( end - start )/ 2 ;
               if(target == arr[mid]){
                   return true;
               } else if(target > arr[mid]){
                    start = mid + 1;
               }else {
                   end = mid - 1;
               }
               return bs(arr, target, start, end);
           }
           else{
               return false;
           }




       // return found;
    }


    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        if( high == 0 && target == nums[0]){
            return 0;
        }
        while(low <= high){
            int mid = (low + high) / 2;

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
