package java;

/**
 * Created by haileyyin on 1/24/18.
 */
public class HouseRobberII {
    /*
        two time dynamic programming
        */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob1(nums, 0, nums.length - 1), rob1(nums, 1, nums.length));
    }

    public int rob1(int[] nums, int begin, int end) {
        if (nums == null || begin >= end)
            return 0;
        if ((end - begin) == 1)
            return nums[begin];

        int sum1 = nums[begin];
        int sum2 = Math.max(nums[begin], nums[begin+1]);
        for(int i=begin+2; i<end; i++){
            if((i-begin)%2==0){
                sum1 = Math.max(sum1+nums[i], sum2);
            } else {
                sum2 = Math.max(sum1, sum2+nums[i]);
            }
        }
        return Math.max(sum1, sum2);
    }
}
