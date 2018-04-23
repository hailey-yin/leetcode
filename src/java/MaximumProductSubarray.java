package java;

/**
 * Created by haileyyin on 4/16/18.
 */
public class MaximumProductSubarray {
    /*
    space: O(1)
    time: O(n)
    */
    public int maxProduct(int[] nums) {
        if(nums.length==0)
            return 0;
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for(int i=1; i<nums.length; i++){
            int temp = max;
            max = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            min = Math.min(Math.min(temp*nums[i],min*nums[i]),nums[i]);
            res = Math.max(max,res);
        }
        return res;
    }
}
