package java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by haileyyin on 4/4/18.
 */
public class LongestIncreasingSubsequence {

    /*
    brutal force: O(n^2)
    DP + Binary Search: O(nlogn)
    维护一个单调递增序列，遍历数组，二分查找每一个数在单调序列中的位置，然后替换之。
    */
    public int lengthOfLIS(int[] nums) {
        int[] array = new int[nums.length];
        int res = 0;
        for(int num:nums){
            int i=0, j=res;
            while(i!=j){
                int mid = (i+j)/2;
                if(array[mid]<num){
                    i = mid+1;
                } else {
                    j = mid;
                }
            }
            array[i] = num;
            if(i==res)
                res++;
        }
        return res;
    }
}
