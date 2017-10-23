package java;

import java.util.Arrays;

/**
 * Created by haileyyin on 10/21/17.
 */
public class NextPermutation {
    /*
    Start from the last element in the array, traverse backwards to find the first element with index i that satisfies nums[i-1]<nums[i].
    We can see that elements from noms[i] to noms[n-2] is sorted.
    To find the next permutation, we swap nums[i-1] with the smallest number in noms[i] to noms[n-2]
     */
    public void nextPermutation(int[] nums) {

        if(nums.length<2) return;

        boolean ifSwap = false;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i-1]<nums[i]){
                for(int j=nums.length-1; j>i-1; j--){
                    if(nums[j]>nums[i-1]){
                        swap(nums, i-1, j);
                        break;
                    }
                }
                ifSwap = true;
                reverseSort(nums,i,nums.length-1);
                break;
            }
        }
        if(!ifSwap){
            reverseSort(nums, 0, nums.length-1);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp=0;
        temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverseSort(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
