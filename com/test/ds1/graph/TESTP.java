package com.test.ds1.graph;
import java.util.HashMap;
import java.util.Map;

public class TESTP {

	public static void main(String[] args) {
		//System.out.println(7%10);
		//System.out.println(7/10);
		
		int [] arr = { -1, -2, -3, -4, -5};
		
		int [] ret = twoSum(arr, -8);
		
		System.out.println(ret);
		
	}

    public static int[] twoSum(int[] nums, int target) {
        int [] ret = {0,0};
        int arrLen = nums.length;
        Map<Integer, Integer> map = new HashMap<>(arrLen);
        
        for(int i=0; i< arrLen; i++){
            if(map.containsKey(target-nums[i])){
                ret[0] = i;
                ret[1] = map.get(target-nums[i]);
            }else{
                map.put(nums[i], i);
            } 
        }

        return ret;
    }
	
	
}
