package java;

/**
 * Created by haileyyin on 3/20/18.
 */
public class DeleteandEarn {
    /*
    Dynamic Programming

    Time: O(M+N)
    Space: O(N)

    M: the length of input array
    N: the range of the value of each int element, in this case [1, 10000]
    */
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for(int num:nums){
            count[num] += num;
        }
        int[] dp = new int[10003];
        for(int i=10000; i>=0; i--){
            dp[i] = Math.max(count[i]+dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}
