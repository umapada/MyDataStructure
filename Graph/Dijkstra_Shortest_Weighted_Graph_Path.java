package Graph;

import java.util.*;

// Data structure to store graph edges
class Edge {
    int source, dest, weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
};

// data structure to store heap nodes
 class Node {
    int vertex, weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    Node() {
    }
};

// class to represent a graph object
class GraphD {
    int V;
    // A List of Lists to represent an adjacency list
    List<Edge>[] adjList;

    // Constructor
    GraphD(List<Edge> edges, int N) {
        V = N;
        adjList = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList();
        }

        // add edges to the undirected graph
        for (Edge edge : edges) {
            adjList[edge.source].add(edge);
        }
    }
}

class Dijkstra_Shortest_Weighted_Graph_Path {

    public static void main(String[] args) {
        // initialize edges as per above diagram
        // (u, v, w) triplet represent undirected edge from
        // vertex u to vertex v having weight w
          /*      List<Edge> edges = Arrays.asList(
                 new Edge(0, 4, 3),new Edge(0, 1, 2),
                new Edge(1, 2, 2), new Edge(1, 4, 4),
                new Edge(2, 3, 1), new Edge(3, 2, 7),
                 new Edge(4, 2, -2), new Edge(4, 1, 1),
                new Edge(4, 3, 4)
        );
                */
 /*       List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 1),new Edge(0, 2, -2),
                new Edge(1, 2, -5)
        );
*/

   /*     List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 4), new Edge(0, 2, 4),
                new Edge(2, 4, 4),new Edge(2, 5, -2),
                new Edge(3, 0, 3),new Edge(3, 2, 2),
                new Edge(4, 3, 1),new Edge(4, 6, -2)
                ,new Edge(5, 1, 3)//,new Edge(5, 4, -3)
                ,new Edge(6, 5, 2),new Edge(6, 7, 2), new Edge(4, 7, -12)
                //,new Edge(7, 4, -2)
                );
*/

        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, -1), new Edge(0, 2, 4),
                new Edge(1, 4, 2), new Edge(1, 2, 3), new Edge(1, 3, -2),
                new Edge(2, 3, 5),
                new Edge(3, 1, 1),
                new Edge(4, 3, -8)
        );

        // Set number of vertices in the graph
        final int N = 5;

        // construct graph
        GraphD graph = new GraphD(edges, N);

        dijkstra(graph, 0, N);
        System.out.println("============BELLMAN-FORD=======================");
        bellmanFord(graph, 0, N, edges);
        System.out.println("============MINIMUM SPANNING- PRIMS=======================");

        minimum_spanning_Prims(graph);
    }

    private static void printRoute(int prev[], int i) {
        if (i == -1)
            return;

        printRoute(prev, prev[i]);
        System.out.print(i + " ");
    }

    static void bellmanFord(GraphD graph, int source, int N, List<Edge> edges) {

        int prev[] = new int[N];
        prev[source] = -1;

        // Step 1: Initialize distances from src to all other
        // vertices as INFINITE
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Step 2: Relax all edges |V| - 1 times. A simple shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for (int i = 0; i < N; i++) {
            for (Edge e : edges) {
                int u = e.source;
                int v = e.dest;
                int weight = e.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                }
            }
        }

        // Step 3: check for negative-weight cycles. The above step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter path, then there is a cycle.
        for (Edge e : edges) {
            int u = e.source;
            int v = e.dest;
            int weight = e.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        //Print graph
        for (int i = 1; i < N; ++i) {
            if (dist[i] == Integer.MAX_VALUE) continue;
            System.out.print("Path from vertex 0 to vertex " + i + " has minimum cost of " + dist[i] + " and the route is [ ");
            printRoute(prev, i);
            System.out.println("]");
        }
    }

    // Run Dijkstra's algorithm on given graph
    public static void dijkstra(GraphD graph, int source, int N) {// Dijkstra Shortest algorithm for weighted graph
        // create min heap and push source node having distance 0
        PriorityQueue<Node> minHeap = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        minHeap.add(new Node(source, 0));
        // set infinite distance from source to v initially
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // distance from source to itself is zero
        dist[source] = 0;
        // boolean array to track vertices for which minimum cost is already found
        boolean[] visited = new boolean[N];
        visited[0] = true;
        // stores predecessor of a vertex (to print path)
        int prev[] = new int[N];
        prev[0] = -1;
        // run till minHeap is not empty
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            int u = node.vertex;
            visited[u] = true;
            for (Edge edge : graph.adjList[u]) {
                int v = edge.dest;
                int weight = edge.weight;
                // Relaxation step
                if (!visited[v] && (dist[u] + weight) < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                    minHeap.add(new Node(v, dist[v]));
                }
            }
        }
        for (int i = 0; i < N; ++i) {
            if (dist[i] == Integer.MAX_VALUE) continue;
            System.out.print("Path from vertex 0 to vertex " + i + " has minimum cost of " + dist[i] + " and the route is [ ");
            printRoute(prev, i);
            System.out.println("]");
        }
    }

    static void minimum_spanning_Prims(GraphD graph) {
        boolean[] visited = new boolean[graph.V];
        int[] dist = new int[graph.V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // Stores the parents of a vertex
        int[] parent = new int[graph.V];
        visited[0] = true;
        Queue<Node> queue = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        queue.add(new Node(0, 0));
        // Loops until the queue is not empty
        while (!queue.isEmpty()) {
            // Extracts a node with min key value
            Node nd = queue.poll();
            int u = nd.vertex;
            visited[u] = true;
            // For all adjacent vertex of the extracted vertex V for (Node iterator : graph.adj[node0.vertex]) {
            for (Edge edge : graph.adjList[u]) {
                int v = edge.dest;
                int weight = edge.weight;
                if (!visited[edge.dest]) {
                    // If the key value of the adjacent vertex is more than the extracted key
                    // update the key value of adjacent vertex to update first remove and add the updated vertex
                    if (dist[v] > weight) {
                        dist[v] = weight;
                        parent[v] = u;
                        queue.add(new Node(v, dist[v]));
                    }
                }
            }
        }
        for (int i = 1; i < graph.V; i++) {
            if(parent[i] != -1)
                System.out.println(i + " =>  " + parent[i]);
        }
    }

}

