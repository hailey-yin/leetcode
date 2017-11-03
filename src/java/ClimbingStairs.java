package java;

/**
 * Created by haileyyin on 11/2/17.
 */
public class ClimbingStairs {
    /*
   define dp[i] as the number of distinct way to get to the ith steps.

   To get the ith step, either take one step up from the (i-1)th steps or take two steps up from the (i-2)th steps.
   dp[i] = dp[i-2]+dp[i-1]

    */
    public int climbStairs(int n) {
        if(n==0)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}
