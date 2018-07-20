package java;

/**
 * Created by haileyyin on 7/20/18.
 */
public class IntegerBreak {
    /*
    dynamic programming
    dp[i] = max(dp[1]*dp[i-1] + dp[2]*dp[i-1] + ... + dp[i/2]*dp[i/2])
    base case:
    dp[0] = 0
    dp[1] = 1
    desired result: dp[n]
    space: O(n)
    time: O(n^2)
    */
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
                max = Math.max(max, dp[j]*dp[i-j]);
                max = Math.max(max, j*dp[i-j]);
                max = Math.max(max, dp[j]*(i-j));
                max = Math.max(max, j*(i-j));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
