package java;

import java.util.Arrays;

/**
 * Created by haileyyin on 4/5/18.
 */
public class WiggleSortII {
    /*
    排序，找中位数
    大于中位数，从右往左进行插入，插到数组从左往右的奇数位
    小于中位数，从右往左进行插入，插到数组从右往左的奇数位
    中位数最后放
    Time: O(nlogn)
    */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] temp = new int[n];
        int mid = (n-1)/2;
        int idx = 0;
        for(int i=0; i<=mid; i++){
            temp[idx] = nums[mid-i];
            if(idx+1<n)
                temp[idx+1] = nums[n-i-1];
            idx += 2;
        }
        System.arraycopy(temp, 0, nums, 0, n);
    }
}
