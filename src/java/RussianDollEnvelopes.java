package java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by haileyyin on 4/4/18.
 */
public class RussianDollEnvelopes {
    /*
    DP的解法，这是一种brute force的解法
    首先要给所有的信封按从小到大排序，首先根据宽度从小到大排，如果宽度相同，那么高度小的再前面
    然后我们开始遍历，对于每一个信封，我们都遍历其前面所有的信封，如果当前信封的长和宽都比前面那个信封的大，那么我们更新dp数组，通过dp[i] = max(dp[i], dp[j] + 1)。
    然后我们每遍历完一个信封，都更新一下结果res
    Time: O(n^2)
    Space: O(n)
    */
    public int maxEnvelopes(int[][] envelopes) {
        if (   envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length == 0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] e1, int[] e2){
                return e1[0]-e2[0];
            }
        });
        int   n  = envelopes.length;
        int[] dp = new int[n];
        int ret = 0;
        for (int i = 0; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (   envelopes[i][0] > envelopes[j][0]
                        && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
