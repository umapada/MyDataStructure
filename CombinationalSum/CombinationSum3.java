package CombinationalSum;
/*

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used
and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.
Example 1: Input: k = 3, n = 7 Output: [[1,2,4]]
Example 2: Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]

 */


import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public static void main(String[] args) {
        combinationSum3(3,9).stream().forEach(System.out::println);
    }

    static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(result, current, k, 1, n);
        return result;
    }

    static void helper(List<List<Integer>> result, List<Integer> current, int k, int start, int sum){
        if(sum<0){
            return;
        }

        if(sum==0 && current.size()==k){
            result.add(new ArrayList<Integer>(current));
            return;
        }

        for(int i=start; i<=9; i++){
            current.add(i);
            helper(result, current, k, i+1, sum-i);
            current.remove(current.size()-1);
        }
    }

}
