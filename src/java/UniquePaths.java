package java;

/**
 * Created by haileyyin on 11/15/17.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }
        if(m<=0 || n<= 0){
            return -1;
        }
        int[][] paths = new int[m][n];

        paths[0][0] = 1;
        for(int i=1; i<m; i++){
            paths[i][0] = 1;
            for(int j=1; j<n; j++){
                paths[0][j] = 1;
                paths[i][j] = paths[i-1][j]+paths[i][j-1];
            }
        }
        return paths[m-1][n-1];
    }
}
