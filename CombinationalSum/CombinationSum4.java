package CombinationalSum;

/*

Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add
up to a positive integer target.

Java Solution
This problem is similar to Coin Change. It's a typical dynamic programming problem.

 */

public class CombinationSum4 {

    public static void main(String[] args) {
        int [] arr = {2,3,6,7};
        System.out.println(combinationSum4(arr,7)); // 223, 232, 322, 7
    }

    static int combinationSum4(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return 0;

        int[] dp = new int[target+1];

        dp[0]=1;

        for(int i=0; i<=target; i++){
            for(int number: nums){

                if(i + number <= target){
                    dp[ i+number ] = dp[i] + dp[ i+number ];
                }
            }
        }

        return dp[target];
    }

}
