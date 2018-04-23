package java;

/**
 * Created by haileyyin on 4/14/18.
 */
public class GameofLife {
    /*
    brutal force:
    time: O(mn)
    space: O(mn)
    */
    public void gameOfLife(int[][] board) {
        if(board.length==0||board[0].length==0)
            return;
        int m = board.length;
        int n = board[0].length;
        int[][] temp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                temp[i][j] = board[i][j];
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = numberOfLiving(temp, i, j);
                if(temp[i][j]==1){
                    board[i][j] = count<2||count>3?0:1;
                } else {
                    board[i][j] = count==3?1:0;
                }
            }
        }
    }

    private int numberOfLiving(int[][] temp, int i, int j){
        int count = 0;
        if(i>0)
            count += temp[i-1][j];
        if(i<temp.length-1)
            count += temp[i+1][j];
        if(j>0)
            count += temp[i][j-1];
        if(j<temp[0].length-1)
            count += temp[i][j+1];
        if(i>0&&j>0)
            count += temp[i-1][j-1];
        if(i>0&&j<temp[0].length-1)
            count += temp[i-1][j+1];
        if(i<temp.length-1&&j<temp[0].length-1)
            count += temp[i+1][j+1];
        if(i<temp.length-1&&j>0)
            count += temp[i+1][j-1];
        return count;
    }

    /*
    bit manipulation
    time: O(mn)
    space: O(1)
    */
    public void gameOfLife2(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);

                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Get the 2nd state.
            }
        }
    }

    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                if(x==i&&y==j)
                    continue;
                if((board[x][y]&1)==1)
                    lives++;
            }
        }
        return lives;
    }
}
