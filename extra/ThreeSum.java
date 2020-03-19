package extra;

/*

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*

    This problem can be solved by using two pointers. Time complexity is O(n^2).
To avoid duplicate, we can take advantage of sorted arrays, i.e., move pointers by >1 to
use same element only once.

 */


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums == null || nums.length<3)
            return result;

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            if(i==0 || nums[i] > nums[i-1]){
                int j=i+1;
                int k=nums.length-1;

                while(j<k){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);

                        j++;
                        k--;

                        //handle duplicate here
                        while(j<k && nums[j]==nums[j-1])
                            j++;
                        while(j<k && nums[k]==nums[k+1])
                            k--;

                    }else if(nums[i]+nums[j]+nums[k]<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }

        }

        return result;
    }


    public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if(diff == 0) return sum;

                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    public static int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int min_space = Integer.MAX_VALUE;

        for(int i = 0; i< nums.length - 2; i++){
            int left = i+1;
            int right = nums.length -1;
            while(left < right){
                int sum = nums[i] + nums[left]+nums[right];
                if(sum < target) left++;
                else{
                    right--;
                }
                if(Math.abs(target - sum) < min_space){
                    min_space = Math.abs(target - sum);
                    res = sum;
                }
            }
        }
        return res;
    }

}
