package com.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> list = threeSum(nums);

        list.stream().forEach(System.out::println);

    }
    public static List<List<Integer>> threeSum(int[] nums) {

        List<Integer> innerList = null;
        List<List<Integer>> outerList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int len = nums.length;

        for(int i = 0; i < len-1; i ++){
            for(int j = i + 1; j < len; j ++){

                int a = nums[i];
                int b = nums[j];
                int sum = a + b ;

                if(set.contains(-sum)){
                    innerList = new ArrayList<>();
                    innerList.add(nums[i] + nums[j]);
                    innerList.add(nums[i]);
                    innerList.add(nums[j]);
                    outerList.add(innerList);

                  //  set.remove(nums[i] + nums[j]);
                }else{
                    set.add(nums[j]);
                }
            }
        }
        return outerList;
    }
}
