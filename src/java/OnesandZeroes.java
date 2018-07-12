package java;

/**
 * Created by haileyyin on 7/9/18.
 */
public class OnesandZeroes {
    /*
    dynamic programmng:

    0-1 knapsack problem, we need to pick several strings to get the maximum number of strings using limited number of 0 and 1.

    dp[i][j][k] represents the maximum number of strings we can get from the first i argument strings using j number of 0's and k number of 1's.

    for dp[i][j][k], we can get it by choosing the current string i or not, which would result in:
        dp[i][j][k] = dp[i - 1][j - number of 0 in string i][k - number of 1 in string i]
        or
        dp[i][j][k] = dp[i-1][i][j]

    base case:
    dp[0][j][k] = 0
    dp[i][0][k] = 0
    dp[i][j][0] = 0

    desired solution:
    dp[I][J][K]

    Time Complexity: O(kl + kmn), where k is the length of input string array and l is the average length of a string within the array.
     */

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for (int i = 0; i <= strs.length; i++) {
            int[] count = new int[]{0,0};
            if (i > 0) {
                count = calculate(strs[i-1]);
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i == 0) {
                        dp[i][j][k] = 0;
                    } else if (j>=count[0] && k>=count[1]) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-count[0]][k-count[1]]+1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private int[] calculate(String str) {
        int[] res = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                res[0]++;
            } else {
                res[1]++;
            }
        }
        return res;
    }
}
