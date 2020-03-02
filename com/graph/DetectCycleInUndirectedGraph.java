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
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
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

    // A recursive function that uses visited[] and parent to detect
    // cycle in subgraph reachable from vertex v.
    static boolean isCyclicUtil(Graph graph, int v, Boolean visited[], int parent)
    {
        // Mark the current node as visited
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = graph.adjacencyList[v].iterator();
        for (Integer children: graph.getOutEdges(v)) {
            if (!visited[children])
            {
                if (isCyclicUtil(graph,children, visited, v))
                    return true;
            }
            // If an adjacent is visited and not parent of current vertex, then there is a cycle.
            else if (children != parent)
                return true;
        }
        return false;
    }

    // Returns true if the graph contains a cycle, else false.
     static boolean isCyclic(Graph grpah)
    {
        // Mark all the vertices as not visited and not part of
        // recursion stack
        Boolean visited[] = new Boolean[grpah.noOfVertices];
        for (int i = 0; i < grpah.noOfVertices; i++)
            visited[i] = false;

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
}
