package CombinationalSum;
/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the
candidate numbers sums to T. Each number in C may only be used ONCE in the combination.

Note:
1) All numbers (including target) will be positive integers.
2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
3) The solution set must not contain duplicate combinations.
Java Solution

This problem is an extension of Combination Sum. The difference is one number in the array can only be used ONCE.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        int [] arr = {2,2,3,6,7,4,2};
        combinationSum2(arr,7).stream().forEach(System.out::println);
    }

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, 0, target,  current, result,-1);

        return result;
    }

    static void helper(int[] candidates, int start, int target, List<Integer> current, List<List<Integer>> result, int prev) {

        if(target<0){
            return;
        }

        if(target==0){
            result.add(new ArrayList<Integer>(current));
            return;
        }

       // int prev=-1;
        for(int i=start; i<candidates.length; i++){
            if(prev!=candidates[i]){ // each time start from different element
                current.add(candidates[i]);
                prev=candidates[i];
                helper( candidates,i+1, target-candidates[i],current, result, prev); // and use next element only
                current.remove(current.size()-1);

            }
        }
    }

}
