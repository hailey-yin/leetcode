package java;

/**
 * Created by haileyyin on 11/15/17.
 */
public class UniquePath2 {
    /*
    space complexity: O(1);
    time complexity: O(mn);
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m==0)
            return 0;
        int n = obstacleGrid[0].length;
        if(n==0)
            return 0;
        int block1 = obstacleGrid[0][0];
        int block2 = obstacleGrid[0][0];
        obstacleGrid[0][0] = obstacleGrid[0][0]==1?-1:1;
        for(int i=1; i<m; i++){
            if(obstacleGrid[i][0]==1 || block1 ==1){
                obstacleGrid[i][0] = -1;
                block1 = 1;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }
        if(n==1)
            return block1==1?0:1;
        for(int i=1; i<n; i++){
            if(obstacleGrid[0][i]==1 || block2 ==1){
                obstacleGrid[0][i] = -1;
                block2 = 1;
            } else {
                obstacleGrid[0][i] = 1;
            }

        }
        if(m==1)
            return block2==1?0:1;
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j]==0){
                    obstacleGrid[i][j] = (obstacleGrid[i-1][j]==-1?0:obstacleGrid[i-1][j])+(obstacleGrid[i][j-1]==-1?0:obstacleGrid[i][j-1]);
                } else {
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        return obstacleGrid[m-1][n-1]==-1?0:obstacleGrid[m-1][n-1];
    }
}
