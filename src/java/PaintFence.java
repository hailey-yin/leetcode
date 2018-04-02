package java;

/**
 * Created by haileyyin on 4/1/18.
 */
public class PaintFence {
    /*
    attention:题目要求是不超过两根柱子颜色相同，说明相邻两根柱子可以同颜色
    */
    public int numWays(int n, int k) {
        if (n == 0 || k == 0)
            return 0;
        if (n == 1)
            return k;
        // same[i] means the ith post has the same color with the (i-1)th post.
        int[] same = new int[n];
        // diff[i] means the ith post has a different color with the (i-1)th post.
        int[] diff = new int[n];
        same[0] = same[1] = k;
        diff[0] = k;
        diff[1] = k * (k - 1);
        for (int i = 2; i < n; ++i) {
            same[i] = diff[i-1];
            // 递推式：第三根柱子要么根第一个柱子不是一个颜色，要么跟第二根柱子不是一个颜色
            diff[i] = (k - 1) * (same[i-1] + diff[i-1]);
        }
        return same[n-1] + diff[n-1];
    }
}
