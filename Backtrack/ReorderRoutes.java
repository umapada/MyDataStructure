package Backtrack;

import java.util.*;

//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
/*
There are n cities numbered from 0 to n-1 and n-1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [a, b] represents a road from city a to b.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach the city 0 after reorder.



Example 1:



Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:



Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 3:

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0
 */
public class ReorderRoutes {
    int res=0;
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> map= new HashMap<>();
        for (int[] c: connections) {
            map.computeIfAbsent(c[0], k->new LinkedList<>()).add(c[1]);
            map.computeIfAbsent(c[1], k->new LinkedList<>()).add(-c[0]);

        }
        dfs(map, 0, new HashSet<>());
        return res;
    }
    public void dfs( Map<Integer, List<Integer>> map, int cur, Set<Integer> vis){
        if (!vis.add(Math.abs(cur))) return;
        if (cur>0) res++;
        for (int next: map.get(Math.abs(cur))){
            dfs(map, next, vis);
        }
        vis.remove(cur);
    }
}
