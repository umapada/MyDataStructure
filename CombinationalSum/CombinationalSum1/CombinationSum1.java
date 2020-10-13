package CombinationalSum.CombinationalSum1;

/*

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate
numbers sums to T. The same repeated number may be chosen from C unlimited number of times.

Note: All numbers (including target) will be positive integers. Elements in a combination (a1, a2, ... , ak) must be in
non-descending order. (ie, a1 <= a2 <= ... <= ak). The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, A solution set is:
[7]
[2, 2, 3]
Java Solution

The first impression of this problem should be depth-first search(DFS). To solve DFS problem, recursion is a normal implementation.
The following example shows how DFS works: (See Attached picture)

 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {

    public static void main(String[] args) {
       // int [] arr = {2,3,6,7};
        int [] arr = {1,1,2,3};

        combinationSum(arr,4).stream().forEach(System.out::println);
    }

     static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(candidates, 0, target,  current, result);
        return result;
    }

     static void helper(int[] candidates, int start, int target,  List<Integer> current, List<List<Integer>> result) {
        if ( target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            helper(candidates, i,  target - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}