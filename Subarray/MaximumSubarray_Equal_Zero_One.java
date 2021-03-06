package Subarray;

import java.util.HashMap;
import java.util.Map;

/*

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.

 */
public class MaximumSubarray_Equal_Zero_One {

    public static void main(String[] args) {
        int [] nums = {0,0,1,1,0,1,1,1,0};
        int out = new MaximumSubarray_Equal_Zero_One().findMaxLength(nums);
        System.out.println(out);
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                count++;
            }else{
                count--;
            }
           // count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return maxlen;
    }

}
