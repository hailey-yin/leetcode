package java;

/**
 * Created by haileyyin on 11/16/17.
 */
public class MinimumPathSum {
    /*
    dp[i][j] = MIN(dp[i-1][j],dp[i][j-1])+grid[i][j]

    space complexity: O(mn)
    time complexity: O(mn)
    */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m==0)
            return 0;
        int n = grid[0].length;
        if(n==0)
            return 0;
        if(m==1){
            int sum = 0;
            for(int i=0; i<grid[0].length; i++){
                sum +=grid[0][i];
            }
            return sum;
        }
        if(n==1){
            int sum = 0;
            for(int i=0; i<grid.length; i++){
                sum +=grid[i][0];
            }
            return sum;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=1; i<m; i++){
            dp[i][0] = grid[i][0]+dp[i-1][0];
            for(int j=1; j<n; j++){
                dp[0][j] = grid[0][j]+dp[0][j-1];
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
