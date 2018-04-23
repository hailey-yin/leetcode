package java;

/**
 * Created by haileyyin on 4/22/18.
 */
public class FindPeakElement {
    /*
    binary search: recursion

    If num[i-1] < num[i] > num[i+1], then num[i] is peak
    If num[i-1] < num[i] < num[i+1], then num[i+1…n-1] must contains a peak
    If num[i-1] > num[i] > num[i+1], then num[0…i-1] must contains a peak
    If num[i-1] > num[i] < num[i+1], then both sides have peak

    Time: O(logn)
    Space: O(logn)
    */
    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private int helper(int[] num, int start, int end){
        if(start == end){
            return start;
        }else if(start+1 == end){
            if(num[start] > num[end]) return start;
            return end;
        }else{
            int m = (start+end)/2;
            if(num[m] > num[m-1] && num[m] > num[m+1]){
                return m;
            }else if(num[m-1] > num[m] && num[m] > num[m+1]){
                return helper(num,start,m-1);
            }else{
                return helper(num,m+1,end);
            }
        }
    }

    /*
    binary search: iteration
    */
    public int findPeakElement2(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(nums[mid]>nums[mid+1]){
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }
}
