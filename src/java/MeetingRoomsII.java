package java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by haileyyin on 4/1/18.
 */
public class MeetingRoomsII {
    /*
    greedy,heap
    Time: O(nlogn)
    Space: O(n)
    */
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.end-b.end;
            }
        });
        heap.offer(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            Interval interval = heap.poll();
            if(intervals[i].start>=interval.end){
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();
    }
}
