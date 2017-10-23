package java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 10/21/17.
 */
public class A4Sum {
    /*
    The idea is to sort an input array first and then run through all indices of a possible first element of a quadruplets.
    For each possible first element, we run through all indices of a possible second element of a quadruplets,
    and then we make a standard bi-direction 2Sum sweep of the remaining part of the array.
    Also we want to skip equal elements to avoid duplicates in the answer.
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0; i<nums.length-3; i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1; j<nums.length-2; j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int lo = j+1;
                int hi = nums.length-1;
                int sum = target-nums[i]-nums[j];
                while(lo<hi){
                    if(nums[lo]+nums[hi]==sum){
                        res.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
                        while(lo<hi&&nums[lo]==nums[lo+1])
                            lo++;
                        while(lo<hi&&nums[hi]==nums[hi-1])
                            hi--;
                        lo++;hi--;

                    } else if(nums[lo]+nums[hi]>sum){
                        hi--;
                    } else {
                        lo++;
                    }
                }

            }
        }
        return res;
    }
}
