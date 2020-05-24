package com.graph;

//Java program to print BFS traversal from a given source vertex.
//BFS(int s) traverses vertices reachable from s.
import java.util.*;

//This class represents a directed graph using adjacency list representation
class BFSGraph {
	// Driver method to
	public static void main(String args[]) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		BFSTraverse(g,2);
	}

	// prints BFS traversal from a given source s
	static void BFSTraverse(Graph g, int s) {
		// Mark all the vertices as not visited(By default set as false)
		boolean visited[] = new boolean[g.noOfVertices];
		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();
		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (!queue.isEmpty()) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s + " ");
			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it visited and enqueue it
			for(Integer children:g.adjacencyList[s] ){
				if (!visited[children]) {
					visited[children] = true;
					queue.add(children);
				}
			}
		}
	}
}
