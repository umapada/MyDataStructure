package Graph;

import java.util.List;

/**
 * Given a graph of V nodes represented in the form of the adjacency matrix. The task is to find the shortest distance
 * of all the vertex's from the source vertex.
 */


class ImplementingDijkstra
{
    static void dijkstra(List<List<Integer>> list, int src, int V) {
        int dist[] = new int[V];
        boolean sptSet[]= new boolean[V];

        for(int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for(int count = 0; count < V-1; count++)
        {
            int u = minDistance(dist, sptSet, V);
            sptSet[u] = true;
            for(int v = 0; v < V; v++)
            {
                if(!sptSet[v] && list.get(u).get(v) != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+list.get(u).get(v) < dist[v])
                    dist[v] = dist[u] + list.get(u).get(v);
            }
        }
        printSolution(dist, V);
    }
    static void printSolution(int dist[], int n)
    {
        for(int i = 0; i < n; i++)
            System.out.print(dist[i] + " ");
    }

    static int minDistance(int dist[], boolean sptSet[], int V)
    {

        int min = Integer.MAX_VALUE, min_index = 0;
        for(int v = 0; v < V; v++)
        {
            if(sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }
}