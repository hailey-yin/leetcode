package java;

/**
 * Created by haileyyin on 4/16/18.
 */
public class FindMinimuminRotatedSortedArray {
    /*
    lo    mid    hi
     0 1 2 4 5 6 7
     7 0 1 2 4 5 6
     6 7 0 1 2 4 5
     5 6 7 0 1 2 4

     4 5 6 7 0 1 2
     2 4 5 6 7 0 1
     1 2 4 5 6 7 0

     binary search
     time:O(logn)
    */
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo<hi){
            int mid = (hi+lo)/2;
            if(nums[mid]<nums[hi]){
                hi = mid;
            } else{
                lo = mid+1;
            }
        }
        return nums[lo];
    }
}
