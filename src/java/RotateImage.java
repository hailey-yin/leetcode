package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class RotateImage {
    /*
    这是一个多维数组变换的问题，题目要求把一个n*n的二维matrix，顺时针旋转90度。有两种实现方法。
    方法一：
    将数组转置(transpose，相当于逆时针旋转九十度)，再左右对称地翻转(flip symmerically)
    [i, j] => [j, i] => [j, n-1-i]
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        if(n>1&&matrix[0].length==n){
            //transpose
            for(int i=0; i<n; i++){
                for(int j=i; j<n; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;

                }
            }
            //flip symmetrically
            for(int i=0; i<n; i++){
                for(int j=0; j<n/2; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n-1-j];
                    matrix[i][n-1-j] = temp;
                }
            }
        }
    }

    /*
    方法二：
    优化：先将数组上下对称反转，再进行转置。上下翻转时，每行元素在行内位置不变，因此可以减少一个for循环。
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        // Reverse
        for (int i = 0; i < n / 2; ++i) {
            int j = n - 1 - i;
            int[] cache = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = cache;
        }
        // Transpose
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int cache = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = cache;
            }
        }
    }

    /*
    方法三：
    直接顺时针旋转90度，只需要找到点与点之间的对应关系。
    [i, j] => [j, n-i]

    每个元素搬运不会超过一次，时间复杂度是n^2，空间复杂度是1
     */
    public void rotate3(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}
