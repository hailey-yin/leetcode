package java;

/**
 * Created by haileyyin on 4/5/18.
 */
public class GuessNumberHigherorLowerII {
    /*
    Dynamic programming
    dp[i,j]：i-j 的序列能赢最少需要多少钱

    最小的最大值问题：
    i-j中任意猜一个数x,获胜所花的钱为x+max(dp[i,x-1],dp[x+1,j])
    */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1; i>0; i--){
            for(int j=i+1; j<=n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int x=i; x<j; x++){
                    dp[i][j] = Math.min(dp[i][j],x+Math.max(dp[i][x-1],dp[x+1][j]));
                }
            }
        }
        return dp[1][n];
    }
}
