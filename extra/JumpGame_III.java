package extra;

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the
 * array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach
 * to any index with value 0.
 */

/**
 * Example 1:
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 *
 * Example 2:
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true
 * Explanation:
 * One possible way to reach at index 3 with value 0 is:
 * index 0 -> index 4 -> index 1 -> index 3
 *
 * Example 3:
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 *
 *
 * Constraints:
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 * Solution:
 * The easiest way to think about this problem would be from any given position, we can jump two new positions.
 * This hint tells you that it sounds like a tree. You need to traverse from that two new positions and so on.
 * To avoid repeating work, we need to track the visiting position. Why? Because if you came to the same position,
 * you are sure that you keep traversing infinitely.
 * Another thing is that whenever you find ‘0’, you need to return.
 */

public class JumpGame_III {

    public static void main(String[] args) {
       int [] arr = {4,2,3,0,3,1,2};
       int start = 6;
        System.out.println(canReach(arr,start));
    }

    public static boolean canReach(int[] arr, int start) {
        boolean [] visited = new boolean[arr.length];

        return isZeroExists(arr, visited, start);
    }

    static boolean  isZeroExists(int [] A, boolean [] visited, int jump){
        if(jump >= 0 && jump < A.length){
            if(A[jump] == 0){
                return true;
            }
        }
        if(jump >= 0 && jump < A.length && !visited[jump]){
            visited[jump] = true;
            return isZeroExists(A, visited, jump - A[jump]) || isZeroExists(A, visited, jump + A[jump]);
        }
        return false;
    }
}
