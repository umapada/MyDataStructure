package Interval_CourseSchedule;
/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {return x[0] - y[0];});
        List<Interval> input = new ArrayList<>();
        List<Interval> output = new ArrayList<>();

        for(int[] i: intervals){
            Interval interval = new Interval(i[0],i[1]);
            input.add(interval);
        }

        for(int i=0; i < input.size(); i++){
            if(output.size() == 0){
                output.add(input.get(i));
            }else{
                Interval object2 = input.get(i);
                Interval object1 = output.remove(output.size()-1);
                if(object1.end >= object2.start){
                    Interval temp = new Interval(object1.start, Math.max(object1.end, object2.end));
                    output.add(temp);
                }else{
                    output.add(object1);
                    output.add(object2);

                }
            }
        }

        int [][] ret = new int[output.size()][2];
        int index = 0;
        for(Interval object: output){
            ret[index][0] = object.start;
            ret[index][1] = object.end;
            index++;
        }
        return ret;
    }
}

class Interval{
    int start;
    int end;
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
    public String toString(){
        return start + "-" + end;
    }
}