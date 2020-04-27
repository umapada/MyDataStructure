package TEST;


import javax.crypto.spec.PSource;
import java.util.*;

class TEST {

    // c = 97, z = 122, 0 = 48, 9 = 57, A = 65, Z = 90

    Queue<int[]> Q = new PriorityQueue<>((x,y) -> ((int)Math.sqrt(x[0]*x[0] + x[1]*x[1])) - ((int)Math.sqrt(y[0]*y[0] + y[1]*y[1])) );



    public static void main(String[] args) {
        TreeSet<Integer> s = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));


    }
}

class Graph{
    int V;
    List[] adj;
    Graph(int V){
        adj = new LinkedList[V];
        this.V = V;
        for(int i=0; i< V; i++){
            adj[i] = new LinkedList();
        }

    }



}

class Solution {
    Stack<Integer> stack = new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);
        boolean [] visited = new boolean[numCourses];
        boolean [] recStack = new boolean[numCourses];
        int []ret = new int[numCourses];

        for(int[] edge:prerequisites){
            int start = edge[0];
            int end = edge[1];
            g.adj[start].add(end);
        }

        for(int i=0; i< numCourses; i++){
                boolean isCyclic = checkCycle(g, i, visited, recStack);
                if (isCyclic) {
                    return ret;
                }
        }

        Arrays.fill(visited,false);

        for(int i=0; i< numCourses; i++){
            if(!visited[i]){
                dfs(g,i, visited);
            }
        }
       // int []ret = new int[numCourses];
        int index = 0;
        while(!stack.isEmpty()){
            ret[index++] = stack.pop();
        }
        return ret;
    }

    void dfs(Graph g, int i,  boolean [] visited){
        visited[i] = true;
        List<Integer> adj = g.adj[i];
        for(int j: adj){
            if(!visited[j]){
                dfs(g,j,visited);
            }
        }
        stack.push(i);
    }

    boolean checkCycle(Graph g, int i, boolean [] visited, boolean [] recStack){
        if(recStack[i]){
            return true;
        }
        if(visited[i]){
            return false;
        }
        recStack[i] = true;
        visited[i] = true;

        List<Integer> list = g.adj[i];
        for(int j: list){
                boolean b = checkCycle(g,j,visited,recStack);
                if(b){
                    return true;
                }
        }
        recStack[i] = false;;
        return false;
    }

}