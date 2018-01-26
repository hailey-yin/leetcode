package java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by haileyyin on 1/25/18.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        final Set<Integer> distinct = new HashSet<Integer>();
        for(int num : nums) {
            if(distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }
    public boolean containsDuplicate2(int[] nums) {

        Arrays.sort(nums);
        for(int ind = 1; ind < nums.length; ind++) {
            if(nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }
}
