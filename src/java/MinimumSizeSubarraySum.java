package java;

/**
 * Created by haileyyin on 1/24/18.
 */
public class MinimumSizeSubarraySum {
    /*
    Brutal force:
    Walk through the array from left to right. For each item, find the nearest item with which they form a subarray that the sum >=s. And the answer is the minimal length above all.
    */
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>=s){
                min = 1;
            } else {
                int sum = nums[i];
                for(int j=i+1; j<nums.length; j++){
                    sum += nums[j];
                    if(sum>=s){
                        min = Math.min(min, j-i+1);
                        break;
                    }
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
    /*
    two pointers: i,j. sum小于target时向后移动j, sum大于target时向后移动i
    */
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
