package Schedule;

/*
//https://leetcode.com/problems/meeting-scheduler/
Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.



Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]
Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []
 */

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {return x[0] - y[0];});

        for (int[] s : slots1)
            if (s[1] - s[0] >= duration)
                pq.offer(s);

        for (int[] s : slots2)
            if (s[1] - s[0] >= duration)
                pq.offer(s);

        while (pq.size() > 1){
            if (pq.poll()[1] >= pq.peek()[0] + duration)
                return Arrays.asList(pq.peek()[0], pq.peek()[0] + duration);
        }

        return Arrays.asList();
    }
}




