package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 3/23/18.
 */

/*
binary search

case -1:[3,6] 2 > [2,6]
case 0: [3,6] 1 > [1] [3,6]
case 1: [3,6] 5 > [3,6]
case 2: [3,4] 5 > [3,4,5]
case 3: [3,4] 5 [6] > [3,4,5,6]
case 4: [3,4] 5 [7] > [3,4,5] [7]
case 5: [3,4] 6 > [3,4] [6]
case 6: [3,4] 6 [7] > [3,4] [6,7]
case 7: [3] 5 [7] > [3] [5] [7]
*/

public class DataStreamasDisjointIntervals {
    List<Interval> res;
    /** Initialize your data structure here. */
    public DataStreamasDisjointIntervals() {
        res = new LinkedList<>();
    }

    public void addNum(int val) {
        if(res.size()==0){
            res.add(new Interval(val,val));
            return;
        }
        //find the last interval with start time smaller than it
        int lo = 0;
        int hi = res.size()-1;
        int mid = 0;
        while(lo<=hi){
            mid = lo+(hi-lo)/2;
            if(res.get(mid).start==val){
                return;
            } else if(res.get(mid).start<val){
                if(mid==res.size()-1||res.get(mid+1).start>val){
                    break;
                } else {
                    lo = mid+1;
                }
            } else {
                hi = mid-1;
            }
        }
        if(lo>hi){
            if(val+1==res.get(0).start){
                //case -1
                res.set(0, new Interval(val, res.get(0).end));
            } else {
                //case 0
                res.add(0, new Interval(val,val));
            }
        } else {
            Interval cur = res.get(mid);
            if(cur.end>=val){
                //case 1
                return;
            } else if(cur.end<val){
                if(cur.end==val-1){
                    if(mid==res.size()-1){
                        //case 2
                        res.set(mid, new Interval(cur.start, val));
                    } else {
                        Interval next = res.get(mid+1);
                        if(next.start==val+1){
                            //case 3
                            res.set(mid, new Interval(cur.start, next.end));
                            res.remove(mid+1);
                        } else {
                            //case 4
                            res.set(mid, new Interval(cur.start, val));
                        }
                    }
                } else {
                    if(mid==res.size()-1){
                        //case 5
                        res.add(new Interval(val,val));
                    } else {
                        Interval next = res.get(mid+1);
                        if(next.start==val+1){
                            //case 6
                            res.set(mid+1, new Interval(val, next.end));
                        } else {
                            //case 7
                            res.add(mid+1, new Interval(val,val));
                        }
                    }
                }
            }
        }
    }

    public List<Interval> getIntervals() {
        return res;
    }
}
/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */