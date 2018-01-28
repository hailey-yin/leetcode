package java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haileyyin on 1/27/18.
 */
public class FindAllNumbersDisappearedinanArray {
    /*
    Mark the index we have seen as number in the array as negative. In the second iteration, if a value is not marked as negative, its index is the number we haven't seen.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
