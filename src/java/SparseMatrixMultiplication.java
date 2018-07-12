package java;

/**
 * Created by haileyyin on 7/11/18.
 */
public class SparseMatrixMultiplication {
    /*
    time: O(ijm)
    */
    public int[][] multiply(int[][] A, int[][] B) {
        if (A.length == 0 || A[0].length == 0 || B.length == 0 || B[0].length == 0)
            return new int[][]{};
        int[][] ans = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                int value = 0;
                for (int m = 0; m < A[0].length; m++) {
                    value += A[i][m]*B[m][j];
                }
                ans[i][j] = value;
            }
        }
        return ans;
    }
}
