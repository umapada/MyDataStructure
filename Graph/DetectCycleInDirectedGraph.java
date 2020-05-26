package Graph;

/**
 * Detect Cycle in a Directed Graph
 * Given a directed graph, check whether the graph contains a cycle or not. Your function should return true if the
 * given graph contains at least one cycle, else return false.
 * <p>
 * Depth First Traversal can be used to detect a cycle in a Graph. DFS for a connected graph produces a tree.
 * There is a cycle in a graph only if there is a back edge present in the graph. A back edge is an edge that is
 * from a node to itself (self-loop) or one of its ancestor in the tree produced by DFS.
 */

/**
 * Depth First Traversal can be used to detect a cycle in a Graph. DFS for a connected graph produces a tree.
 * There is a cycle in a graph only if there is a back edge present in the graph. A back edge is an edge that is
 * from a node to itself (self-loop) or one of its ancestor in the tree produced by DFS.
 */

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
    public static void main(String[] args) {
        Graph graph = new Graph(2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        if (isCyclic(graph))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }

    private static boolean isCyclicUtil(Graph graph, int i, boolean[] visitedArray, boolean[] recStackArray) {
        // Mark the current node as visited and part of recursion stack
        if (recStackArray[i]) {
            return true;
        }
        if (visitedArray[i]) {
            return false;
        }
        visitedArray[i] = true;
        recStackArray[i] = true;
        List<Integer> children = graph.getOutEdges(i);

        for (Integer c : children) {
            if (isCyclicUtil(graph, c, visitedArray, recStackArray)) {
                return true;
            }
        }
        recStackArray[i] = false;
        return false;
    }

    private static boolean isCyclic(Graph graph) {
        // Mark all the vertices as not visited and not part of recursion stack
        boolean[] visitedArray = new boolean[graph.noOfVertices];
        boolean[] recStackArray = new boolean[graph.noOfVertices];
        // Call the recursive helper function to detect cycle in different DFS trees
        for (int i = 0; i < graph.noOfVertices; i++)
            if (isCyclicUtil(graph, i, visitedArray, recStackArray))
                return true;

        return false;
    }
}
