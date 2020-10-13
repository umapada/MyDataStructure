package TEST;

import java.util.ArrayList;
//      Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
public class IntersectionInterval2 {
    public static void main(String... args) {
        //int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        //int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        int[][] A = {{8,15}};
        int[][] B = {{2,6}, {8, 10}, {12,20}};

        IntersectionInterval2 sol = new IntersectionInterval2();

        ArrayList<Interval> output = sol.intervalIntersection(A, B);

        System.out.println(output);

    }

    ArrayList<Interval> intervalIntersection(int[][] A, int[][] B ){
        ArrayList<Interval> retList = new ArrayList<>();
        ArrayList<Interval> list1 = new ArrayList<>();
        ArrayList<Interval> list2 = new ArrayList<>();
        for(int [] a: A){
            list1.add(new Interval(a[0], a[1]));
        }
        for(int [] b: B){
            list2.add(new Interval(b[0], b[1]));
        }
        int index1 = 0;
        int index2 = 0;

        while(index1 < list1.size() && index2 < list2.size()){

                Interval temp1 = list1.get(index1);
                Interval temp2 = list2.get(index2);
                if(temp1.start <= temp2.start && temp1.start <= temp2.end && temp1.end >= temp2.start){
                    retList.add(new Interval(Math.max(temp1.start, temp2.start), Math.min(temp1.end, temp2.end)));
                    //index1++;
                   // if(temp2.end <= temp1.end) index2++;
                }else if(temp2.start <= temp1.start && temp2.start <= temp1.end && temp2.end >= temp1.start){
                    retList.add(new Interval(Math.max(temp2.start, temp1.start), Math.min(temp2.end, temp1.end)));
                   // index2++;
                   // if(temp1.end <= temp2.end) index1++;
                }
            if(temp2.end <= temp1.end) index2++;
            else if(temp1.end <= temp2.end) index1++;
              else  if(temp1.end < temp2.start ) index1++;
                    else if(temp2.end < temp1.start) index2++;
                    else {
                        index1++;
                        index2++;
                    }



        }



        return retList;
    }

}
