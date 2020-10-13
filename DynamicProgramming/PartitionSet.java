package DynamicProgramming;

/*
Given a set of positive numbers, partition the set into two subsets with a minimum difference between their subset sums.

Example 1: #
Input: {1, 2, 3, 9}
Output: 3
Explanation: We can partition the given set into two subsets where minimum absolute difference
between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
Example 2: #
Input: {1, 2, 7, 1, 5}
Output: 0
Explanation: We can partition the given set into two subsets where minimum absolute difference
between the sum of number is '0'. Following are the two subsets: {1, 2, 5} & {7, 1}.
Example 3: #
Input: {1, 3, 100, 4}
Output: 92
Explanation: We can partition the given set into two subsets where minimum absolute difference
between the sum of numbers is '92'. Here are the two subsets: {1, 3, 4} & {100}.
 */

class PartitionSet {


    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
       num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }

    public int canPartition(int[] num) {

       int res =  this.canPartitionRecursive(num, 0, 0, 0);

        int sum = 0;
        for(int i:num){
            sum+=i;
        }
        Integer [][] dp = new Integer[num.length][sum+1];

      // res =  this.canPartitionTD(num, dp,0, 0, 0);
        return res;
    }

    private int canPartitionRecursive(int[] num, int index, int sum1, int sum2) {
        // base check
        if (index == num.length)
            return Math.abs(sum1 - sum2);

        // recursive call after including the number at the currentIndex in the first set
        int diff1 = canPartitionRecursive(num, index + 1, sum1 + num[index], sum2);

        // recursive call after including the number at the currentIndex in the second set
        int diff2 = canPartitionRecursive(num,index + 1, sum1, sum2 + num[index]);

        return Math.min(diff1, diff2);
    }

    private int canPartitionTD(int[] num, Integer [][] dp, int index, int sum1, int sum2) {
        // base check
        if (index == num.length)
            return Math.abs(sum1 - sum2);

        if(dp[index][sum1] == null){
            // recursive call after including the number at the currentIndex in the first set
            int diff1 = canPartitionTD(num, dp, index + 1, sum1 + num[index], sum2);

            // recursive call after including the number at the currentIndex in the second set
            int diff2 = canPartitionTD(num, dp, index + 1, sum1, sum2 + num[index]);
            dp[index][sum1] = Math.min(diff1, diff2);
        }

        return dp[index][sum1];
    }



    //BottomUp

    public int canPartitionBU(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i];

        int n = num.length;
        boolean[][] dp = new boolean[n][sum/2 + 1];

        // populate the sum=0 columns, as we can always form '0' sum with an empty set
        for(int i=0; i < n; i++)
            dp[i][0] = true;

        // with only one number, we can form a subset only when the required sum is equal to that number
        for(int s=1; s <= sum/2 ; s++) {
            dp[0][s] = (num[0] == s ? true : false);
        }

        // process all subsets for all sums
        for(int i=1; i < num.length; i++) {
            for(int s=1; s <= sum/2; s++) {
                // if we can get the sum 's' without the number at index 'i'
                if(dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                } else if (s >= num[i]) {
                    // else include the number and see if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i-1][s-num[i]];
                }
            }
        }

        int sum1 = 0;
        // Find the largest index in the last row which is true
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[n-1][i] == true) {
                sum1 = i;
                break;
            }
        }

        int sum2 = sum - sum1;
        return Math.abs(sum2-sum1);
    }




}