package java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 4/2/18.
 */
public class RemoveBoxes {
    /*
    dp[i][j][k]，表示区间[i, j]中能获得的最大积分，当boxes[i]左边有k个数字跟其相等，那么我们的目标就是要求dp[0][n-1][0]
     */
    private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];

        for (; i + 1 <= j && boxes[i + 1] == boxes[i]; i++, k++); // optimization: all boxes of the same color counted continuously from the first box should be grouped together
        int res = (k + 1) * (k + 1) + removeBoxesSub(boxes, i + 1, j, 0, dp);

        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                res = Math.max(res, removeBoxesSub(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub(boxes, m, j, k + 1, dp));
            }
        }

        dp[i][j][k] = res;
        return res;
    }
    /*
   brutal force
   */
    public int removeBoxes2(int[] boxes) {
        List<Integer> list = new LinkedList<>();
        for(int i=0; i<boxes.length; i++){
            list.add(boxes[i]);
        }
        return helper(list);
    }

    private int helper(List<Integer> list){
        int[] dp = new int[list.size()];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++){
            if(i>0&&list.get(i)==list.get(i-1)){
                dp[i] = dp[i-1];
            } else {
                int j=i;
                while(j+1<list.size()&&list.get(j+1)==list.get(i)){
                    j++;
                }
                List<Integer> newlist = new LinkedList<>();
                newlist.addAll(list);
                newlist.subList(i, j+1).clear();
                dp[i] = (j-i+1)*(j-i+1)+helper(newlist);
            }
        }
        for(int i=0; i<dp.length; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return removeBoxesSub(boxes, 0, n - 1, 0, dp);
    }
}
