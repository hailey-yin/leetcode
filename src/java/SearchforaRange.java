package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class SearchforaRange {
    /*
    Use Binary Search to pin down one target number, and then use while loop to find its left bound and right bound.
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums.length==1&&nums[0]==target){
            result[0]=0;
            result[1]=0;
            return result;
        }
        int lo = 0;
        int hi = nums.length-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(nums[mid]==target){
                lo = mid;
                hi = mid;
                while(lo>0&&nums[lo-1]==nums[lo]){
                    lo--;
                }
                while(hi<nums.length-1&&nums[hi+1]==nums[hi]){
                    hi++;
                }
                result[0]=lo;
                result[1]=hi;
                return result;
            } else if(nums[mid]<target){
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return result;
    }
}
