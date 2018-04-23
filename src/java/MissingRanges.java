package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 4/22/18.
 */
public class MissingRanges {
    /*
    [-2147483648,2147483647]
     -2147483648
     2147483647

     output:     ["2147483648->2147483647","-2147483647->2147483646"]
     expected:   ["-2147483647->2147483646"]

     Integer.MAX_VALUE = 2147483647 is 01111111111111111111111111111111
     Integer.MIN_VALUE = -2147483648 is 11111111111111111111111111111111
     */

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<>();
        long pre = lower;
        for(int i=0; i<nums.length; i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            if(nums[i]!=pre){
                if(nums[i]-pre==1){
                    res.add(pre+"");
                } else {
                    res.add(pre+"->"+(nums[i]-1));
                }
            }
            pre = (long)nums[i]+1;
        }
        if(pre<=upper){
            if(pre==upper){
                res.add(upper+"");
            } else {
                res.add(pre+"->"+upper);
            }
        }
        return res;
    }
}
