package java;

/**
 * Created by haileyyin on 10/26/17.
 */
public class BestTimetoBuyandSellStockwithTransactionFee {

    /*
    divide & conquer: max(left, right, span),span include its left max value and right max value.
    Time Limit Exceeded
     */
    public int maxProfit1(int[] prices, int fee) {
        return helper(prices, 0, prices.length-1, fee);
    }

    private int helper(int[] prices, int start, int end, int fee){
        if(start>=end)
            return 0;
        if(start+1==end)
            return prices[end]-prices[start]-fee;
        int medium = (end+start)/2;
        int leftmax = helper(prices, start, medium, fee);
        int rightmax = helper(prices, medium+1, end, fee);
        leftmax = leftmax<0?0:leftmax;
        rightmax = rightmax<0?0:rightmax;
        int spanmax = 0;
        for(int i=start; i<=medium; i++){
            for(int j=medium+1; j<=end; j++){
                int sale = prices[j]-prices[i]-fee;
                int left = helper(prices, start, i-1, fee);
                int right = helper(prices, j+1, end, fee);
                left = left<0?0:left;
                right = right<0?0:right;
                spanmax = Math.max(left+sale+right, spanmax);
            }
        }
        return Math.max(leftmax+rightmax, spanmax);
    }
    /*
    加dp
    dp[i][j] = max(dp[i][k]+dp[k+1][j]) for i<=k<j
    Time Limit Exceeded

    但up to bottom，所以同样不行
     */
    public int maxProfit2(int[] prices, int fee) {
        int[][] dp = new int[prices.length][prices.length];
        return helper(prices, 0, prices.length-1, fee,dp);
    }
    private int helper(int[] prices, int start, int end, int fee, int[][] dp){
        if(start>=end)
            return 0;
        if(dp[start][end]!=0)
            return dp[start][end];
        if(start+1==end){
            dp[start][end] = prices[end]-prices[start]-fee;
            return prices[end]-prices[start]-fee;
        }
        int medium = (end+start)/2;
        int leftmax = helper(prices, start, medium, fee, dp);
        int rightmax = helper(prices, medium+1, end, fee, dp);
        leftmax = leftmax<0?0:leftmax;
        rightmax = rightmax<0?0:rightmax;
        int spanmax = 0;
        for(int i=start; i<=medium; i++){
            for(int j=medium+1; j<=end; j++){
                int sale = prices[j]-prices[i]-fee;
                int left = helper(prices, start, i-1, fee, dp);
                int right = helper(prices, j+1, end, fee, dp);
                left = left<0?0:left;
                right = right<0?0:right;
                spanmax = Math.max(left+sale+right, spanmax);
            }
        }
        int max = Math.max(leftmax+rightmax, spanmax);
        dp[start][end] = max<=0?-1:max;
        return max;
    }
    /*
    Bottom to up dp:
    Time Limit Exceeded
     */
    public int maxProfit3(int[] prices, int fee) {
        int[][] dp = new int[prices.length][prices.length];

        for(int length=1; length<prices.length; length++){
            for(int i=0; i+length<prices.length; i++){
                int max = 0;
                for(int j=i; j<i+length; j++){
                    max = Math.max(dp[i][j]+dp[j+1][i+length],max);
                }
                int sale = prices[i+length]-prices[i]-fee;
                max = Math.max(max,sale);
                dp[i][i+length] = max<0?0:max;
            }
        }
        return dp[0][prices.length-1];
    }
    /*
        At given day, we can do 1 out of 4 things:
        buy stock
        hold stock
        do nothing with empty portfolio
        sell stock
        We have 4 arrays with the length of # of the days, recording the max profit at given day if we do given operation.
         */
    public int maxProfit4(int[] prices, int fee) {
        if(prices.length <= 1) return 0;
        int[] buy = new int[prices.length];
        int[] hold = new int[prices.length];
        int[] skip = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = 0 - prices[0];
        hold[0] = 0 - prices[0];
        for(int i = 1; i < prices.length; i++){
            buy[i] = Math.max(skip[i-1], sell[i-1]) - prices[i];
            hold[i] = Math.max(buy[i-1], hold[i-1]);
            skip[i] = Math.max(skip[i-1], sell[i-1]);
            sell[i] = Math.max(buy[i-1], hold[i-1]) + prices[i] - fee;
        }
        // Get the max of all the 4 actions on the last day.
        int max = Math.max(buy[prices.length - 1], hold[prices.length - 1]);
        max = Math.max(skip[prices.length - 1], max);
        max = Math.max(sell[prices.length - 1], max);
        return Math.max(max, 0);
    }

    /*
    in this dp problem, we do not need to record all the four

    define dp array:
    hold[i]: the maximum accumulative profit of holding stock at day i
    nothold[i]: the maximun accumulative profit of not holding stocl at day i

    for day i we have two situations:
    1. hold stock
        - hold stock at day i-1
        - not stock at day i-1, and buy it at day i
    2. not hold stock
        - hold stock at day i-1, sell it at day i
        - not hold stock at day i-1
     */
    public int maxProfit5(int[] prices, int fee){
        if(prices.length<=1)
            return 0;
        int[] hold = new int[prices.length+1];
        int[] nothold = new int[prices.length+1];
        hold[0] = Integer.MIN_VALUE;
        for(int i=1; i<=prices.length; i++){
            hold[i] = Math.max(hold[i-1], nothold[i-1]-prices[i-1]-fee);
            nothold[i] = Math.max(nothold[i-1], hold[i-1]+prices[i-1]);
        }
        return nothold[prices.length];
    }
}
