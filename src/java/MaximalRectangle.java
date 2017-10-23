package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class MaximalRectangle {
    /*
    可以转化为多个直方图求最大面积的问题(no. 84)，每一行可以转化为一个直方图求出最大面积，最后返回值为所有面积的最大值。
    比如上图：
    Row1: [1,0,1,0,0]
    Row2: [2,0,2,1,1]
    Row3: [3,1,3,2,2]
    Row4: [4,0,0,3,0]

    求高度是一个动态规划过程。用dp[i][j]来存某个位置的高度那么
    对于第i行第j列的点：
    if (matrix[i][j] == '1')
　    　dp[i][j] = dp[i-1][j] + 1;
    else
　    　dp[i][j] = 0;
     */
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 ||matrix[0].length==0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int max = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                } else {
                    heights[j]=0;
                }
            }
            int area = largestRectangleArea(heights);
            max = Math.max(max, area);
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        //O(n^2)
        if (heights == null || heights.length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i == heights.length - 1 || heights[i] > heights[i + 1]) {
                int minHeight = heights[i];
                for (int j = i; j >= 0; j--) {
                    minHeight = Math.min(minHeight, heights[j]);
                    max = Math.max(max, minHeight * (i - j + 1));
                }
            }
        }
        return max;
    }
}
