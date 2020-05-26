package Backtrack;

import java.util.ArrayList;
import java.util.List;
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class PowerSet {

    public static void main(String[] args) {
        int a [] = {6,2,3,7};

        System.out.println(subsets(a));
    }
    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /*
      public List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> output = new ArrayList();

      if(nums == null || nums.length == 0){
          return output;
      }

      for(int i=0; i< (1<<nums.length) ; i++){
          List<Integer> list = new ArrayList<>();
          for(int j=0; j<nums.length; j++){
              if((i & (1<<j)) > 0){
                  list.add(nums[j]);
              }
          }
          output.add(list);
      }
      return output;
    }
     */
}