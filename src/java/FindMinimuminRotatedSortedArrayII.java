package java;

/**
 * Created by haileyyin on 4/16/18.
 */
public class FindMinimuminRotatedSortedArrayII {
    /*
    binary search
    多一个判断条件
     */
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo<hi){
            int mid = (hi+lo)/2;
            if(nums[mid]<nums[hi]){
                hi = mid;
            } else if(nums[mid]>nums[hi]){
                lo = mid+1;
            } else {
                hi--;
            }
        }
        return nums[lo];
    }
}
