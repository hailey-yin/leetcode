package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 11/14/17.
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
    /*
        greedy algorithm:
        the idea is to sort the intervals by their starting points.Then we start with the first interval, and find the end of the last interval that overlaps with it if it exists. And then we start from the first non-overlapping interval, and do it again.
        Time complexity: O(n)
        Space complexity: O(n)
        */
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1){
            return intervals;
        }
        //Sort by ascending starting point
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> res = new LinkedList();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i).start<=end && intervals.get(i).end>end){
                end = intervals.get(i).end;
            } else if(intervals.get(i).start>end){
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        if((res.size()==0 )|| (res.size()>0 && res.get(res.size()-1).end != end))
            res.add(new Interval(start, end));
        return res;
    }
}
