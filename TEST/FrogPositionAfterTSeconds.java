package TEST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Jump {
    int frequency;
    List<Integer> nodeList = new ArrayList<>();

    Jump(int frequency) {
        this.frequency = frequency;
    }
}

public class FrogPositionAfterTSeconds {

    static Map<Integer, Jump> frequenyMap = new HashMap<>();
    static double prob = 0.0;
    static boolean[] visited = null;


    public static void main(String[] args) {
        //Input: n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
        //n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7

//        int n = 7, t = 2, target = 4;
//        int [][]edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};

//        int n = 7, t = 1, target = 7;
//        int [][]edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};

//        int n = 3, t = 1, target = 2;
//        int[][] edges = {{2, 1}, {3, 2}};

//        int n = 7, t = 20, target = 6;
//        int [][]edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};

        int n = 8, t = 7, target = 7;
        int [][]edges = {{2,1},{3,2},{4,1},{5,1},{6,4},{7,1},{8,7}};




        frogPosition(n, edges, t, target);
        System.out.println(prob);
    }

    static double frogPosition(int n, int[][] edges, int t, int target) {

        double probability = 0.0;
        visited = new boolean[n + 1];

        for (int[] edge : edges) {
            if (frequenyMap.containsKey(edge[0])) {
                Jump jump = frequenyMap.get(edge[0]);
                jump.nodeList.add(edge[1]);
                jump.frequency++;
            } else {
                Jump jump = new Jump(1);
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                jump.nodeList = list;
                frequenyMap.put(edge[0], jump);
            }

            if (frequenyMap.containsKey(edge[1])) {
                Jump jump = frequenyMap.get(edge[1]);
                jump.nodeList.add(edge[0]);
              //  jump.frequency++;
            } else {
                Jump jump = new Jump(0);
                List<Integer> list = new ArrayList<>();
                list.add(edge[0]);
                jump.nodeList = list;
                frequenyMap.put(edge[1], jump);
            }
        }

        for (int[] edge : edges) {
            if (!frequenyMap.containsKey(edge[1])) {
                Jump jump = new Jump(0);
                frequenyMap.put(edge[1], jump);
            }
        }

         getTarget(1, 1, t, target);

        return prob;
    }

    static double getTarget(int node, double probable, int t, int target) {
        if (!visited[node]) {
            visited[node] = true;

            if (t >= 0 && node == target) {
                prob = probable;
                return probable;
            } else {
                int f = frequenyMap.get(node).frequency;
                if (f != 0) {
                    probable = probable * 1.0 / f;
                }

                List<Integer> list = frequenyMap.get(node).nodeList;
                for (int nd : list) {
                    getTarget(nd, probable, t - 1, target);
                }
                return 0;
            }
        } else {
            return 0;
        }

    }


}
