package Graph;

/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
 */

//Approach 1: Depth First Search

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Node1 {
    public int val;
    public List<Node1> neighbors;

    public Node1() {}

    public Node1(int _val,List<Node1> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

public class CloneGraph {
    private HashMap<Node1, Node1> visited = new HashMap <> ();
    public Node1 cloneGraph(Node1 node) {
        if (node == null) {
            return node;
        }

        // If the node was already visited before.
        // Return the clone from the visited dictionary.
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the given node.
        // Note that we don't have cloned neighbors as of now, hence [].
        Node1 cloneNode = new Node1(node.val, new ArrayList());
        // The key is original node and value being the clone node.
        visited.put(node, cloneNode);

        // Iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to the cloned node.
        for (Node1 neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}

/*
Complexity Analysis

Time Complexity: O(N)O(N) since we process each node exactly once.
Space Complexity: O(N)O(N). This space is occupied by the visited hash map and in addition to that, space would also be
occupied by the recursion stack since we are adopting a recursive approach here. The space occupied by the recursion stack
would be equal to O(H)O(H) where HH is the height of the graph. Overall, the space complexity would be O(N)O(N).
 */


//Approach 2: Breadth First Search

class BFS_DeepClone {
    public Node1 cloneGraph(Node1 node) {
        if (node == null) {
            return node;
        }

        // Hash map to save the visited node and it's respective clone
        // as key and value respectively. This helps to avoid cycles.
        HashMap<Node1, Node1> visited = new HashMap();

        // Put the first node in the queue
        LinkedList<Node1> queue = new LinkedList<> ();
        queue.add(node);
        // Clone the node and put it in the visited dictionary.
        visited.put(node, new Node1(node.val, new ArrayList()));

        // Start BFS traversal
        while (!queue.isEmpty()) {
            // Pop a node say "n" from the from the front of the queue.
            Node1 n = queue.remove();
            // Iterate through all the neighbors of the node "n"
            for (Node1 neighbor: n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and put in the visited, if not present already
                    visited.put(neighbor, new Node1(neighbor.val, new ArrayList()));
                    // Add the newly encountered node to the queue.
                    queue.add(neighbor);
                }
                // Add the clone of the neighbor to the neighbors of the clone node "n".
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        // Return the clone of the node from visited.
        return visited.get(node);
    }
}