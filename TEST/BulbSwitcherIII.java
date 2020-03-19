package TEST;
//Bulb Switcher III
/*
There is a room with n bulbs, numbered from 1 to n, arranged in a row from left to right. Initially, all the bulbs are
turned off.
At moment k (for k from 0 to n - 1), we turn on the light[k] bulb. A bulb change color to blue only if it is on and all
the previous bulbs (to the left) are turned on too.

Return the number of moments in which all turned on bulbs are blue.

Example 1:
Input: light = [2,1,3,5,4]
Output: 3
Explanation: All bulbs turned on, are blue at the moment 1, 2 and 4.
Example 2:

Input: light = [3,2,4,1,5]
Output: 2
Explanation: All bulbs turned on, are blue at the moment 3, and 4 (index-0).
Example 3:

Input: light = [4,1,2,3]
Output: 1
Explanation: All bulbs turned on, are blue at the moment 3 (index-0).
Bulb 4th changes to blue at the moment 3.
Example 4:

Input: light = [2,1,4,3,6,5]
Output: 3
Example 5:

Input: light = [1,2,3,4,5,6]
Output: 6

Constraints:

n == light.length
1 <= n <= 5 * 10^4
light is a permutation of  [1, 2, ..., n]
 */


public class BulbSwitcherIII {

    public static void main(String[] args) {
        int [] input ={1,8,3,4,9,6,7,2,5,10};
//        int [] input ={1,2,3,4,5,6};

        int j = numTimesAllBlue(input);

        System.out.println(j);
    }

    public static int numTimesAllBlue(int[] light) {
        int n = light.length;
        int[] status = new int[n]; // 0 -> off, 1 -> yellow, 2 -> blue
        int yellow = 0;
        int res = 0;
        for (int i: light) {
            //System.out.println(i + " <-");
            status[i - 1] = 1;
            yellow++;
            if (i == 1 || status[i - 2] == 2) { // check if left light is in blue
                status[i - 1] = 2;
                yellow--;
                while (i < n && status[i] == 1) { // update all continuous yellow lights to blue in right
                    status[i] = 2;
                    yellow--;
                    i++;
                  //  System.out.println(i + " ->");
                }
            }

            if (yellow == 0) {
                res++;
            }
        }

        return res;
    }

}
