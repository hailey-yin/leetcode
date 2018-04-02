package java;

import java.util.Arrays;

/**
 * Created by haileyyin on 4/1/18.
 */
public class _3SumSmaller {
    /*
    two pointers
    1. sort the array first
    2. iterater through each number, using each of them as the first elements, and then using two pointers to find the last two triplets
    */
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            int left = i+1, right = n-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]<target){
                    count += right-left; //attention
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
