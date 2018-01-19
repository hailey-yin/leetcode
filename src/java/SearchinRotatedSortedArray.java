package java;

/**
 * Created by haileyyin on 10/21/17.
 */
public class SearchinRotatedSortedArray {
    /*
    Given the condition, we know that the array is in ascending order to some degree if we traverse backwards;
    and it is also in descending order to some degree if we traverse forwards.
    Therefore, we compare the target with the first element to decide where we start from the first element or the last.
     */
    public int search(int[] nums, int target) {
        int index = 0;
        if(nums.length==0){
            return -1;
        }
        if(target>=nums[0]){
            while(index<nums.length){
                if(target==nums[index])
                    return index;
                index++;
            }
        } else {
            index = nums.length-1;
            while(index>0){
                if(target==nums[index])
                    return index;
                index--;
            }
        }
        return -1;
    }
    /*
    update: O(logn)
    如果A[left] <= A[mid],那么[left,mid] 一定为单调递增序列。
     */
    public int search2(int[] nums, int target) {
        if (nums.length==0)
            return -1;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                if (target > nums[mid] || target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        if (start == end && target != nums[start]) return -1;
        return start;
    }
}
