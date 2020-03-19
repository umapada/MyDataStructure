package Cmpny.Extra;/*

Given an integer array NUMS and an array S find the “contiguous and in the same-order”
subarray of S within NUMS (containing at least one number) which has the largest product.
Example 1:
Input:

S: [2,4,7,10, 120]

NUMS: [2,3,-2, 120, 7, 4, 4, 7,10, 4, -1, 120, 10 ]
Output: 280

Example 2:
Input:

S: [-1, -5, 7, 11]
NUMS: [-2,0,-1, 11, 7, —1, -5, 7]
Output: 35
 */

import java.util.HashMap;
import java.util.Map;

public class Zignal {

    public static void main(String[] args) {

        int []S = {2,4,7,10, 120};
        int [] NUMS = { 2,3,-2, 120, 7, 4, 4, 7,10, 4, -1, 120, 10};
        Map<Integer, Integer> sMap = new HashMap<>();
        for(int i=0; i< S.length; i ++){
            sMap.put(S[i],i);
        }
        int product = 1;
        int preIndex = -1;
        int max = Integer.MIN_VALUE;

        for(int i=0; i< NUMS.length; i++){
            int ele = NUMS[i];
            if(sMap.get(ele) != null){
            int mapIndex = sMap.get(ele);

                if((mapIndex - preIndex) == 1) {
                    product = product * ele;
                    preIndex = mapIndex;
                }else {
                    max = Math.max(max, product);
                    product = ele;
                    preIndex = mapIndex;
                }
        }else{
                max= Math.max(max, product) ;
                product = 1;
            }
        }
        max= Math.max(max, product) ;
        System.out.println(max);
    }
}
