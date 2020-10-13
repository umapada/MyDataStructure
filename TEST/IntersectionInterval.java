package TEST;


import java.util.ArrayList;

//  Question: Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
//
//    Return the intersection of these two interval lists.
//
//    (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection
//    of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.
//    For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
//
//    Example:
//      Input: A = [[0,2],[5,10],[13,23],[24,25]],
//             B = [[1,5],[8,12],[15,24],[25,26]]
//      Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
//
class IntersectionInterval {


    public static void main(String... args) {
      //  int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
       // int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

          int[][] A = {{8,15}};
         int[][] B = {{2,6}, {8, 10}, {12,20}};

        IntersectionInterval sol = new IntersectionInterval();

        ArrayList<Interval> output = sol.intervalIntersection(A, B);

        System.out.println(output);

    }


    public ArrayList<Interval> intervalIntersection(int[][] A, int[][] B) {

        ArrayList<Interval> retList = new ArrayList<>();


        ArrayList<Interval> list1 = new ArrayList<>();
        ArrayList<Interval> list2 = new ArrayList<>();

        if (A == null || A.length == 0) return list2;
        if (B == null || B.length == 0) return list1;

        for (int[] a : A) {
            Interval ivl = new Interval(a[0], a[1]);
            list1.add(ivl);
        }

        for (int[] b : B) {
            Interval ivl = new Interval(b[0], b[1]);
            list2.add(ivl);
        }


        int l1 = 0;
        int l2 = 0;

        Interval prevInterval = null;

        if (list1.get(0).start <= list2.get(0).start) {
            prevInterval = list1.get(0);
            l1 = l1 + 1;
        } else {
            prevInterval = list2.get(0);
            l2 = l2 + 1;
        }


        while (l1 < list1.size() || l2 < list2.size()) {


            if (l2 == list2.size() || l1 < list1.size() && list2.get(l1).start <= list2.get(l2).start) {

                if (prevInterval.end < list1.get(l1).start) {
                    retList.add(prevInterval);
                    prevInterval = list1.get(l1);

                } else {
                    prevInterval.end = Math.max(prevInterval.end, list1.get(l1).end);

                }
                l1++;


            } else {
                if (prevInterval.end < list2.get(l2).start) {
                    retList.add(prevInterval);
                    prevInterval = list2.get(l2);

                } else {
                    prevInterval.end = Math.max(prevInterval.end, list2.get(l2).end);

                }
                l2++;
            }


        }
        retList.add(prevInterval);

        return retList;
        //   int retData = new int[retlist.size()][];


    }


}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return start + ":" + end;
    }

}