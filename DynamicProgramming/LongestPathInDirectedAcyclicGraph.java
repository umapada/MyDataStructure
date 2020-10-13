package DynamicProgramming;


/**
 * Given a Weighted Directed Acyclic Graph (DAG) and a source vertex s in it, find the longest distances from s to all other vertices in the given graph.
 * The longest path problem for a general graph is not as easy as the shortest path problem because the longest path problem doesn’t have optimal substructure property. In fact, the Longest Path problem is NP-Hard for a general graph. However, the longest path problem has a linear time solution for directed acyclic graphs. The idea is similar to linear time solution for shortest path in a directed acyclic graph., we use Topological Sorting.
 *
 * We initialize distances to all vertices as minus infinite and distance to source as 0, then we find a topological sorting of the graph. Topological Sorting of a graph represents a linear ordering of the graph (See below, figure (b) is a linear representation of figure (a) ). Once we have topological order (or linear representation), we one by one process all vertices in topological order. For every vertex being processed, we update distances of its adjacent using distance of current vertex.
 *
 */


import java.util.Arrays;

/**
 * Following is complete algorithm for finding longest distances.
 * 1) Initialize dist[] = {NINF, NINF, ….} and dist[s] = 0 where s is the source vertex. Here NINF means negative infinite.
 * 2) Create a toplogical order of all vertices.
 * 3) Do following for every vertex u in topological order.
 * ………..Do following for every adjacent vertex v of u
 * ………………if (dist[v] < dist[u] + weight(u, v))
 * ………………………dist[v] = dist[u] + weight(u, v)
 */


public class LongestPathInDirectedAcyclicGraph {

    public static void main(String[] args) {
        int[][]	matrix = {
                {1, 1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 0}
        };

        System.out.println(Arrays.stream(matrix[0]).filter(value -> value==1).count());
    }

}
