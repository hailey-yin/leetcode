package java;

import java.util.Arrays;

/**
 * Created by haileyyin on 10/21/17.
 */
public class A3SumClosest {
    /*
    The idea is to sort an input array first and then run through all indices of a possible first element of a triple.
    For each possible first element we make a standard bi-direction 2Sum sweep of the remaining part of the array.
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int clo = nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1];
        for(int i=0; i<nums.length-2; i++){
            int lo = i+1;
            int hi = nums.length-1;
            int sum = target-nums[i];
            while(lo<hi){
                if(nums[lo]+nums[hi]==sum){
                    return target;
                } else if(nums[lo]+nums[hi]<sum){
                    if(Math.abs(target-nums[i]-nums[lo]-nums[hi])<Math.abs(target-clo)){
                        clo = nums[i]+nums[lo]+nums[hi];
                    }
                    lo++;
                } else {
                    if(Math.abs(target-nums[i]-nums[lo]-nums[hi])<Math.abs(target-clo)){
                        clo = nums[i]+nums[lo]+nums[hi];
                    }
                    hi--;
                }
            }
        }
        return clo;
    }
}
