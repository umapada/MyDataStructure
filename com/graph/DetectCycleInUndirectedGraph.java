package com.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Detect cycle in an undirected graph
 * .
 * Given an undirected graph, how to check if there is a cycle in the graph?
 */

//Progress => //4
public class DetectCycleInUndirectedGraph {

    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g1 = new Graph(3);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);

        if (isCyclic(g1))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (isCyclic(g2))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }

    // Returns true if the graph contains a cycle, else false.
    static boolean isCyclic(Graph grpah)
    {
        // Mark all the vertices as not visited and not part of
        // recursion stack
        Boolean visited[] = new Boolean[grpah.noOfVertices];
        // Call the recursive helper function to detect cycle in different DFS trees
        for (int u = 0; u < grpah.noOfVertices; u++) {
            if (!visited[u]) { // Don't recur for u if already visited
                if (isCyclicUtil(grpah,u, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    // A recursive function that uses visited[] and parent to detect
    // cycle in subgraph reachable from vertex v.
    static boolean isCyclicUtil(Graph graph, int v, Boolean visited[], int parent)
    {
        // Mark the current node as visited
        visited[v] = true;
        // Recur for all the vertices adjacent to this vertex
        for(int child: graph.adjacencyList[v]){
            if (!visited[child])
            {
                if (isCyclicUtil(graph,child, visited, v))
                    return true;
            }
            // If an adjacent is visited and not parent of current vertex, then there is a cycle.
            else if (child != parent) {
                return true;
            }
        }
        return false;
    }
}
