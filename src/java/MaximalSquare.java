package java;

/**
 * Created by haileyyin on 1/25/18.
 */
public class MaximalSquare {
    /*
    dynamic programming: ret[i][j] represents the length of maximum square in the matrix with  matrix[i][x] as the left bottom of the square
    ret[i][j] = min{ret[i-1][j], ret[i][j-1]. ret[i-1][j-1]}+1 if matrix[i][j]==1
    */
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)
            return 0;
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ret = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1]=='1'){
                    ret[i][j] = Math.min(ret[i-1][j], Math.min(ret[i][j-1], ret[i-1][j-1]))+1;
                    max = Math.max(max, ret[i][j]);
                }
            }
        }
        return max*max;
    }
}
