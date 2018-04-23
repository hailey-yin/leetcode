package java;

import java.util.Arrays;

/**
 * Created by haileyyin on 4/22/18.
 */
public class TwoSumII {
    /*
    two pointer

    time: O(n)
    */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int lo = 0;
        int hi = numbers.length-1;
        while(lo<hi){
            if(numbers[lo]+numbers[hi]==target){
                res[0] = lo+1;
                res[1] = hi+1;
                break;
            } else if(numbers[lo]+numbers[hi]<target){
                lo++;
            } else {
                hi--;
            }
        }
        return res;
    }

    /*
    binary search

    Time: O(nlogn)
     */
    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = Arrays.binarySearch(nums, i + 1, n, target - nums[i]);
            if (j >= 0) {
                return new int[]{ i + 1, j + 1 };
            }
        }
        return new int[]{ -1, -1 };
    }
}
