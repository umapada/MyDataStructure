package com.array;
/*
//https://leetcode.com/problems/find-in-mountain-array/
ou may recall that an array A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.  If such an index doesn't exist, return -1.

You can't access the mountain array directly.  You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.



Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.

 */


  class MountainArray {
      public int get(int index) { return 0;}
      public int length() {
          return 0;
      }
  }

class FindInMountainArray{
    public int findInMountainArray(int target, MountainArray A) {
        int left = 0, right = A.length() - 1;
        // Find the peak index
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A.get(mid) < A.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int peak = left;

        // Binary search on increasing subarray
        left = 0;
        right = peak;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A.get(mid) < target) {
                left = mid + 1;
            } else if (A.get(mid) > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        // Binary search on decreasing subarray
        left = peak;
        right = A.length() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A.get(mid) < target) {
                right = mid - 1;
            } else if (A.get(mid) > target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}