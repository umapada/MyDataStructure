package Backtrack;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/all-paths-from-source-to-target/
/*
Given a directed acyclic graph of N nodes. Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for
which the edge (i, j) exists.

Example:
Input: [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int [][] input = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(input));
    }
    static int size;
    static List<List<Integer>> retList = new ArrayList<>();
    static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        size = graph.length;
        List<Integer> tempList = new ArrayList<>();
        tempList.add(0);
        dfs(graph, tempList,0);
        return retList;
    }
    static void dfs(int[][] graph, List<Integer> tempList, int start){
        if(start == size-1){
            retList.add(new ArrayList(tempList));
        }else
            for(int n:graph[start]){
                tempList.add(n);
                dfs(graph, tempList,n);
                tempList.remove(tempList.size()-1);
            }
    }
}
