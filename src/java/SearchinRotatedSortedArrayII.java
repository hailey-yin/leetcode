package java;

/**
 * Created by haileyyin on 1/18/18.
 */
public class SearchinRotatedSortedArrayII {
    /*
    允许重复元素，则上一题中如果A[left] <= A[mid],那么[left,mid]为递增序列的假设就不能成立了，比如[1,3,1,1,1]

    有两种可能:
    1. A[left] < A[mid]，则区间[left,mid]一定递增
    2. A[left] == A[mid] 无法确定，跳下一步，left++
    */
    public boolean search(int[] nums, int target) {
        int first = 0, last = nums.length;
        while (first != last) {
            final int mid = first  + (last - first) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[first] < nums[mid]) {
                if (nums[first] <= target && target < nums[mid])
                    last = mid;
                else
                    first = mid + 1;
            } else if (nums[first] > nums[mid]) {
                if (nums[mid] < target && target <= nums[last-1])
                    first = mid + 1;
                else
                    last = mid;
            } else
                first++;
        }
        return false;
    }
}
