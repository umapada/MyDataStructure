package Backtrack;

//https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique
combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(candidates);
        combination(list, tempList,candidates, target, 0 );
        return list;
    }

    void combination(List<List<Integer>> list, List<Integer> tempList,int[] candidates,  int target, int start){
        if(target<0){
            return;
        }else if(target == 0){
            list.add(new ArrayList(tempList));
        }else{
            for(int i = start; i < candidates.length; i ++){
                if( i > start && candidates[i] == candidates[i-1]) continue;
                tempList.add(candidates[i]);
                combination(list, tempList, candidates, target - candidates[i], i + 1 );
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}