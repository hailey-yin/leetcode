package java;

/**
 * Created by haileyyin on 11/14/17.
 */
public class MaximumSubarra {
    /*
   brutal force:
   time complexity: O(n^2)
   space complexity: O(1)
   */
    public int maxSubArray1(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int tempSum = 0;
            for(int j=i; j<nums.length; j++){
                tempSum += nums[j];
                res = Math.max(res, tempSum);
            }
        }
        return res;
    }
    /*
    one for loop
    time complexity: O(n)
    space complexity: O(n)
    */
    public int maxSubArray2(int[] nums) {
        int[] array = new int[nums.length];
        array[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            array[i] = Math.max(array[i-1]+nums[i], nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for(int i:array){
            res = Math.max(res, i);
        }
        return res;
    }
}
