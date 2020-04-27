package com.graph;

//Java program to print DFS traversal from a given given graph
import java.util.*;

//This class represents a directed graph using adjacency list
//representation
class DFSGraph {
	// A function used by DFS
	static void DFSUtil(Graph g, int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		g.adjacencyList[v].stream().forEach(x->{
			if (!visited[x])
				DFSUtil(g, x, visited);
		});
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	static void DFS(Graph g, int v) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[g.noOfVertices];

		// Call the recursive helper function to print DFS traversal
		DFSUtil(g, v, visited);
	}

	public static void main(String args[]) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
		DFS(g, 3);
	}
}
