package java;

/**
 * Created by haileyyin on 1/27/18.
 */
public class RangeSumQueryImmutable {
    int[] dp;

    public RangeSumQueryImmutable(int[] nums) {
        dp = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            dp[i+1] = dp[i]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j+1]-dp[i];
    }
}
