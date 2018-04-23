package java;

/**
 * Created by haileyyin on 4/17/18.
 */
public class BestTimetoBuyandSellStock {
    /*
    和求最大子数列问题是一个解法。
    最大子数列问题的目标是在数列的一维方向找到一个连续的子数列，使该子数列的和最大
    Kadane算法扫描一次整个数列的所有数值，在每一个扫描点计算以该点数值为结束点的子数列的最大和（正数和）。
    */
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
