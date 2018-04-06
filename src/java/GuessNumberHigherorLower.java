package java;

/**
 * Created by haileyyin on 4/5/18.
 */
public class GuessNumberHigherorLower {
    /*
    binary search
    time: O(logn)
     */
    public int guessNumber(int n) {
        int lo=1, hi=n;
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(guess(mid)==0){
                return mid;
            } else if(guess(mid)==1){
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return lo;
    }

    //provided by leetcode
    int guess(int num){
        return 0;
    }
}
