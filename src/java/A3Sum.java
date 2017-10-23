package java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 10/21/17.
 */
public class A3Sum {
    /*
    The idea is to sort an input array first and then run through all indices of a possible first element of a triple.
    For each possible first element we make a standard bi-direction 2Sum sweep of the remaining part of the array.
    Also we want to skip equal elements to avoid duplicates in the answer.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0; i<nums.length-2; i++){
            if(i==0||(i>0&&nums[i]!=nums[i-1])){
                int lo = i+1;
                int hi = nums.length-1;
                int sum = 0-nums[i];
                while(lo<hi){
                    if(nums[lo]+nums[hi]==sum){
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while(lo<hi&&nums[lo]==nums[lo+1]){
                            lo++;
                        }
                        while (hi<hi&&nums[hi]==nums[hi-1]){
                            hi--;
                        }
                        lo++; hi--;
                    } else if(nums[lo]+nums[hi]<sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
