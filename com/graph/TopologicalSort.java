package com.graph;

/**
 * Topological Sorting
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every
 * directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if
 * the graph is not a DAG.
 */

import java.util.Iterator;
import java.util.Stack;

/**
 * Algorithm to find Topological Sorting:
 * We recommend to first see implementation of DFS here. We can modify DFS to find Topological Sorting of a graph.
 * In DFS, we start from a vertex, we first print it and then recursively call DFS for its adjacent vertices.
 * In topological sorting, we use a temporary stack. We don’t print the vertex immediately, we first recursively
 * call topological sorting for all its adjacent vertices, then push it to a stack. Finally, print contents of stack.
 * Note that a vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on)
 * are already in stack.
 */
public class TopologicalSort {

    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological sort of the given graph");
        topologicalSort(g);
    }

    // A recursive function used by topologicalSort
    static void topologicalSortUtil(Graph g ,int v, boolean visited[], Stack stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = g.adjacencyList[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(g,i, visited, stack);
        }
        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }

    // The function to do Topological Sort. It uses recursive topologicalSortUtil()
   static void topologicalSort(Graph g)
    {
        Stack stack = new Stack();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[g.noOfVertices];
        for (int i = 0; i < g.noOfVertices; i++)
            visited[i] = false;

        // Call the recursive helper function to store Topological Sort starting from all vertices one by one
        for (int i = 0; i < g.noOfVertices; i++)
            if (visited[i] == false)
                topologicalSortUtil(g, i, visited, stack);

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }
}
