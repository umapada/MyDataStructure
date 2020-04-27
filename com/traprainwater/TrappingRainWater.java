package com.traprainwater;

/*

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
Analysis

This problem is similar to Candy. It can be solve by scanning from both sides and then get the total.
Java Solution


 */

public class TrappingRainWater {

    public static void main(String[] args) {
        int [] rain_trap = {1,8,6,2,5,4,8,3,7};

        int trap = trap(rain_trap);

        System.out.printf("Tapped Rain Water= " + trap );
    }
    public static int trap(int[] height) {
        int result = 0;

        if(height==null || height.length<=2)
            return result;

        int left[] = new int[height.length];
        int right[]= new int[height.length];

        //scan from left to right
        int max = height[0];
        left[0] = height[0];
        for(int i=1; i<height.length; i++){
            max = Math.max(max, height[i]);
            left[i]=max;
        }
        //scan from right to left
        max = height[height.length-1];
        right[height.length-1]=height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            max = Math.max(max, height[i]);
            right[i] = max;
        }

        //calculate total
        for(int i=0; i<height.length; i++){
            result+= Math.min(left[i],right[i])-height[i];
        }
        return result;
    }

}
