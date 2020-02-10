package com.graph;

/**
 * Detect Cycle in a Directed Graph
 * Given a directed graph, check whether the graph contains a cycle or not. Your function should return true if the
 * given graph contains at least one cycle, else return false.
 */

/**
 * Depth First Traversal can be used to detect a cycle in a Graph. DFS for a connected graph produces a tree.
 * There is a cycle in a graph only if there is a back edge present in the graph. A back edge is an edge that is
 * from a node to itself (self-loop) or one of its ancestor in the tree produced by DFS.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * For a disconnected graph, we get the DFS forest as output. To detect cycle, we can check for a cycle in individual
 * trees by checking back edges.
 *
 * To detect a back edge, we can keep track of vertices currently in recursion stack of function for DFS traversal.
 * If we reach a vertex that is already in the recursion stack, then there is a cycle in the tree. The edge that
 * connects current vertex to the vertex in the recursion stack is a back edge. We have used recStack[] array to keep
 * track of vertices in the recursion stack.
 */
//Progress => //4
public class DetectCycleInDirectedGraph {

    private final int V;
    private final List<List<Integer>> adj;

    public DetectCycleInDirectedGraph(int V)
    {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    public static void main(String[] args)
    {
        DetectCycleInDirectedGraph graph = new DetectCycleInDirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack)
    {

        // Mark the current node as visited and part of recursion stack
        if (recStack[i]) {
            return true;
        }

        if (visited[i]) {
            return false;
        }

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c: children) {
            if (isCyclicUtil(c, visited, recStack)) {
                return true;
            }
        }

        recStack[i] = false;

        return false;
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    private boolean isCyclic()
    {

        // Mark all the vertices as not visited and not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];


        // Call the recursive helper function to detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }


}
