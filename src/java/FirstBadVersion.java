package java;

/**
 * Created by haileyyin on 4/5/18.
 */
public class FirstBadVersion {
    //time: O(logn)
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while(lo<hi){
            int mid = lo + (hi-lo) / 2;  //attention: 如果这里写成mid=(lo+hi)/2会出现溢出问题
            if(!isBadVersion(mid)){
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    boolean isBadVersion(int version){
        //provided by leetcode
        return false;
    }
}
