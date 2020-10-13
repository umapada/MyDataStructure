package TEST;

import java.util.*;

class TEST {
    public static void main(String[] nums) throws Exception{

        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> y.weight - x.weight);

        Node [] node = new Node[5];
        for(int i=0; i< 5; i++){
            node[i] = new Node(i, i*10);
            pq.add(node[i]);
        }



        System.out.println("--------------");
        node[3].weight = 100;
        node[3].vertex = 999;

      //  pq.remove(node[3]);
      //  pq.add(node[3]);

        while(!pq.isEmpty()){
            Node el = pq.poll();
            System.out.println(el.vertex + " - " + el.weight );

        }
    }


}


class Node {
    int vertex, weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    Node() {
    }
};




