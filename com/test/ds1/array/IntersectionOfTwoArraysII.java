package com.test.ds1.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int [] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int [] p = intersect(nums1, nums2);

        for(int i = 0; i<p.length; i++){
            System.out.println(p[i]);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(map.get(nums1[i]) != null){
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i],1);
            }
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {

            if(map.get(nums2[i]) != null){
                list.add(nums2[i]);
                if(map.get(nums2[i]) == 1){
                    map.remove(nums2[i]);
                }
                else {
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }
        }

        int[] ret = new int[list.size()];
        ret = list.stream().mapToInt(i -> i).toArray();

        return ret;
    }
}
