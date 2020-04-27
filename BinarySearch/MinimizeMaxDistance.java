package BinarySearch;
//https://leetcode.com/problems/minimize-max-distance-to-gas-station/
//774. Minimize Max Distance to Gas Station
/*
On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1],
where N = stations.length.

Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

Return the smallest possible value of D.

Example:

Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000

Note:

stations.length will be an integer in range [10, 2000].
stations[i] will be an integer in range [0, 10^8].
K will be an integer in range [1, 10^6].
Answers within 10^-6 of the true value will be accepted as correct.
 */

/*
Explanation of solution
Now we are using binary search to find the smallest possible value of D.
I initilze left = 0 and right = the distance between the first and the last station
count is the number of gas station we need to make it possible.
if count > K, it means mid is too small to realize using only K more stations.
if count <= K, it means mid is possible and we can continue to find a bigger one.
When left + 1e-6 >= right, it means the answer within 10^-6 of the true value and it will be accepted.

Time complexity:
O(NlogM), where N is station length and M is st[N - 1] - st[0]
 */



class MinimizeMaxDistance {

    public static void main(String[] args) {
      int [] stations =  {1, 2, 3, 4, 5, 6, 7, 8, 9, 19};
      int K = 9;
      double res = minmaxGasDist(stations,K);
        System.out.println(res);

    }

    static double minmaxGasDist(int[] st, int K) {
        int count, N = st.length;
        double left = 0, right = st[N - 1] - st[0], mid;

        while (left +1e-6 < right) {
            mid = (left + right) / 2;
            count = 0;
            for (int i = 0; i < N - 1; ++i)
                count += Math.ceil((st[i + 1] - st[i]) / mid) - 1;
            if (count > K) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return right;
    }
}


/*
what does mid mean? The variable mid here is actually a guess of the result, for example, we guess the Max
Distance is 1.3.

with this guess, how many gas stations we need? There are several situations,
For example, mid = 1.3, arr = [1,2,4,8]
how many gas stations between 1 and 2? 0,
how many gas stations we need between 2 and 4? math.ceil((b - a) / mid) - 1 = ceil((4-2)/1.3) - 1 = 1
how many gas stations we need between 4 and 8? ceil((8-4)/1.3) - 1 = 3

what should we do if we don't have enough K?
Increase our guess, so we will need less extra gas stations. For example, if we guess the Max Distance is 2.1,
we only need K = 1

After that, shrink the range until it's accurate enough.
 */