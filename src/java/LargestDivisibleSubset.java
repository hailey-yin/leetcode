package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by haileyyin on 4/4/18.
 */
public class LargestDivisibleSubset {
    /*
    dp[i] denotes the largest size of subset from nums[0] to nums[i]
    pre[i] denotes the last index of the item j that satisfy nums[j]%nums[i]==0
    */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length==0)
            return new ArrayList<>();
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        int max = 0, lastIdx = -1;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            dp[i] = 1;
            pre[i] = -1;
            for(int j = i-1; j>=0; j--){
                if(nums[i]%nums[j]==0&&1+dp[j]>dp[i]){
                    pre[i] = j;
                    dp[i] = dp[j]+1;
                }
            }
            if(dp[i]>max){
                max = dp[i];
                lastIdx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        System.out.println(lastIdx);
        while(lastIdx!=-1){
            res.add(nums[lastIdx]);
            lastIdx = pre[lastIdx];
        }
        return res;
    }
}
