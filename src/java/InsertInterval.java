package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 1/9/18.
 */
public class InsertInterval {
    /*
    1. starting from the first interval, find the last interval with start time smaller than that of new interval.
    2. compare the end time of last interval with the start time of new interval to see if they need to be merged or not.
    3. starting from the last interval we find in step 1, find the last interval with start time smaller than the end time of new interval
    4. if it exists, compare the end time of last interval with the end time of new interval to determine the new end time of the merged interval. Otherwise, no need to merge.
    */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new LinkedList<>();
        int index1 = 0;
        for(int i=0; i<intervals.size(); i++){
            if(intervals.get(i).start>newInterval.start){
                break;
            }
            ans.add(intervals.get(i));
            index1++;
        }
        if(index1>0 && intervals.get(index1-1).end>=newInterval.start){
            ans.remove(ans.size()-1);
            newInterval.start = intervals.get(index1-1).start;
        }
        index1 = index1<1?0:index1-1;
        for(int i=index1; i<intervals.size(); i++){
            if(intervals.get(i).start>newInterval.end)
                break;
            index1++;
        }
        if(index1>0){
            newInterval.end = Math.max(intervals.get(index1-1).end, newInterval.end);
        }
        ans.add(newInterval);
        for(int i=index1; i<intervals.size(); i++){
            ans.add(intervals.get(i));
        }
        return ans;
    }
}
