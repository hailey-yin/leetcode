package java;

import java.util.Arrays;

/**
 * Created by haileyyin on 1/16/18.
 */
public class MergeSortedArray {
    /*
    naive way
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m; i<m+n; i++){
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }

    /*
    update
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int lastIdx = m+n-1;
        int firstEnd = m-1;
        int secondEnd = n-1;
        while(firstEnd>=0 && secondEnd>=0){
            if(nums1[firstEnd]>nums2[secondEnd]){
                nums1[lastIdx] = nums1[firstEnd];
                firstEnd--;
            } else {
                nums1[lastIdx] = nums2[secondEnd];
                secondEnd--;
            }
            lastIdx--;
        }
        if(firstEnd<0){
            while(lastIdx>=0){
                nums1[lastIdx] = nums2[lastIdx];
                lastIdx--;
            }
        }
    }
}
