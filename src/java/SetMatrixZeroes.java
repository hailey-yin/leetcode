package java;

/**
 * Created by haileyyin on 1/9/18.
 */
public class SetMatrixZeroes {
    /*
    create two boolean arrays for each row and column as a flag
    time complexity: O(mn)
    space complexity: O(m+n)
    */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for(int i=0; i<m; i++){
            if(row[i]){
                for(int j=0; j<n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(col[i]){
                for(int j=0; j<m; j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
