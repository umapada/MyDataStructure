package BinarySearch.Advanced;
//https://leetcode.com/problems/divide-chocolate/submissions/
/*
You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array
sweetness.

You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces using
K cuts, each piece consists of some consecutive chunks.

Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.

Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.



Example 1:

Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
Output: 6
Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
Example 2:

Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
Output: 1
Explanation: There is only one way to cut the bar into 9 pieces.
Example 3:

Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
Output: 5
Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]


Constraints:

0 <= K < sweetness.length <= 10^4
1 <= sweetness[i] <= 10^5

 */

class ChocolateDivide {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int K = 5;

        int res = maximizeSweetness(A, K);
        System.out.println(res);
    }

    static int maximizeSweetness(int[] A, int K) {
        int left = 1;
        int right = 1000000000 / (K + 1);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            int cur = 0, cuts = 0;
            for (int a : A) {
                cur = cur + a;
                if (cur >= mid) {
                    cur = 0;
                    cuts = cuts + 1;
                    if (cuts > K) {
                        break;
                    }
                }
            }
            if (cuts > K)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
}
