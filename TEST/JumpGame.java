package TEST;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 */


class JumpGame {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    static boolean canJump(int[] nums) {

        int maxLocation = 0;
        for(int i=0; i<nums.length; i++) {
            // if previous maxLocation smaller than i, meaning we cannot reach location i,
            // thus return false.
            if(maxLocation < i) return false;

            int temp = i+nums[i];
            maxLocation = Math.max(maxLocation,temp);
            if(maxLocation == nums.length){
                break;
            }

        }
        return true;
    }
}

/*
bool canJump(int A[], int n) {
    int last=n-1,i,j;
    for(i=n-2;i>=0;i--){
        if(i+A[i]>=last)last=i;
    }
    return last<=0;
}
 */
