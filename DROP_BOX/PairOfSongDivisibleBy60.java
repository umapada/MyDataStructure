package DROP_BOX;

import java.util.HashMap;
import java.util.Map;

/*
In a list of songs, the i-th song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.



Example 1:

Input: [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 */
public class PairOfSongDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        if (time == null || time.length == 0) return ans;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int rem = time[i]%60;
            ans += map.getOrDefault((60-rem)%60, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return ans;
    }

//Faster
    public int numPairsDivisibleBy602(int[] time) {

        int[] m = new int[60];
        int ret = 0;

        for (int i = time.length - 1; i >= 0; i--){
            ret += m[(60 - time[i]%60)%60];

            m[time[i]%60]++;
        }

        return ret;
    }

}
