package java;

/**
 * Created by haileyyin on 4/17/18.
 */
public class DistinctSubsequences {
    /*
    dp[i][j] denotes the number of distinct subsequences of S[0..i] which equals T[0...j]

    base condition:
    dp[0][0] = 1   an empty string contains the empty string 1 time.
    dp[i][0] = 1   the empty string is a subsequence of any string but only 1 time
    dp[0][j] = 0   an empty string cannot contain a non-empty string as a substring

    desired solution dp[S.length][S.length]

    state transition function:
    S[i]==T[j]: dp[i][j] = dp[i-1][j-1]+dp[i-1][j]
    S[i]!=T[j]: dp[i][j] = dp[i-1][j]

    Memory Limit Exceeded
    Time: O(mn)
    Space: O(mn)
    */
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp =  new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return dp[m][n];
    }
    /*
    二维动规+滚动数组
    Time: O(mn)
    Space: O(n)
    */
    public int numDistinct2(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp =  new int[n+1];
        dp[0] = 1;
        for(int i=0; i<m; i++){
            for(int j=n-1; j>=0; j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[j+1] += dp[j];
                }
            }
        }
        return dp[n];
    }
}
