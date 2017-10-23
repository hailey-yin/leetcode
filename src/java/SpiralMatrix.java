package java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haileyyin on 10/22/17.
 */
public class SpiralMatrix {
    /*
    从矩阵[0,0]位置起始，以螺旋方式遍历矩阵。途中通过四个变量控制走向。

    假设矩阵为m*n
    上方的boundary是u，初始值为0
    下方的boundary是d，初始值为m-1
    左侧的boundary是l，初始值为0
    右侧的boundary是r。初始值为n-1
    k是spiral数组的当前索引，不断往后走。
    控制结束的是这4个方向的索引的大小比较。
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if (matrix.length < 1) return spiral;
        int m = matrix.length, n = matrix[0].length;
        int u = 0, d = m - 1, l = 0, r = n - 1, k = 0;
        while (true) {
            // left-right
            for (int col = l; col <= r; col++) spiral.add(k++, matrix[u][col]);
            if (++u > d) break;
            // up-down
            for (int row = u; row <= d; row++) spiral.add(k++, matrix[row][r]);
            if (--r < l) break;
            // right-left
            for (int col = r; col >= l; col--) spiral.add(k++, matrix[d][col]);
            if (--d < u) break;
            // down-up
            for (int row = d; row >= u; row--) spiral.add(k++, matrix[row][l]);
            if (++l > r) break;
        }
        return spiral;
    }
}
