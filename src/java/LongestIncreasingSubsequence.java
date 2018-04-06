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
    /*
    1. Sort the array. Ascend on width and descend on height if width are same.
    2. Find the longest increasing subsequence based on height.
    Time: O(nlogn)
    Space: O(n)
    */
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length==0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        int res = 0;
        for(int[] envelope:envelopes){
            int i = binarySearch(dp, 0, res, envelope[1]);
            dp[i] = envelope[1];
            if(i==res){
                res++;
            }
        }
        return res;
    }

    private int binarySearch(int[] dp, int start, int end, int target){
        while(start+1<end){
            int mid = (start+end)/2;
            if(dp[mid]==target){
                return mid;
            } else if(dp[mid]<target){
                start = mid;
            } else {
                end = mid;
            }
        }
        if(dp[start]>=target)
            return start;
        return end;
    }
}
