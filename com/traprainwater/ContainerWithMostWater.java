package com.traprainwater;

/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines
are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms
a container, such that the container contains the most water.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

 */


class ContainerWithMostWater {

    public static void main(String[] args) {
        int [] water = {6,8,6,2,5,4,8,3,5};

        int ret = maxArea(water);

        System.out.println(ret);
    }

    static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, temp);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;


    }



}