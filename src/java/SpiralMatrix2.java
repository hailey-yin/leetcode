package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class SpiralMatrix2 {
    /*
    从矩阵[0,0]位置起始，以螺旋方式遍历矩阵。途中通过四个变量控制走向。

    假设矩阵为m*n：
    上方的boundary是u，初始值为0
    下方的boundary是d，初始值为m-1
    左侧的boundary是l，初始值为0
    右侧的boundary是r。初始值为n-1
    k是spiral数组的当前索引，不断往后走。
    控制结束的是这4个方向的索引的大小比较。
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int u = 0, d = n - 1, l = 0, r = n - 1, k = 1;
        while(true){
            //left-right
            for(int col=l; col<=r; col++)
                matrix[u][col]=k++;
            if(++u > d) break;
            //up-down
            for(int row=u; row<=d; row++)
                matrix[row][r]=k++;
            if(--r < l) break;
            //right-left
            for(int col=r; col>=l; col--)
                matrix[d][col]=k++;
            if(--d < u) break;
            //down-up
            for (int row=d; row>=u; row--)
                matrix[row][l]=k++;
            if (++l > r) break;
        }
        return matrix;
    }
}
