package java;

/**
 * Created by haileyyin on 2/4/18.
 */
public class BattleshipsinaBoard {
    /*
    1. Iterate each slot in the board.
    2. If a slot is 'X', get the rectangle size and check inside
    3. Set all the 'X' we have gone through to '.'
    Time Complexity O(mn)
    */
    public int countBattleships(char[][] board) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='X'){
                    //get size
                    int size[] = getSize(board, i, j);
                    //check inside and set '.'
                    boolean flag1 = checkInside(board, i, j, size[0], size[1]);
                    if(flag1)
                        count++;
                }
            }
        }
        return count;
    }

    private boolean checkInside(char[][] board, int i, int j, int height, int length){
        boolean flag = true;
        for(int h=0; h<height; h++){
            for(int l=0; l<length; l++){
                if(board[i+h][j+l]=='X'){
                    board[i+h][j+l] = '.';
                } else {
                    flag = false;
                }
            }

        }
        return flag;
    }

    private int[] getSize(char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        int size[] = new int[2];
        int row = i;
        int col = j;
        while(row<m&&board[row][col]=='X'){
            size[0]++;
            size[1] = Math.max(size[1], getLength(board, row, col));
            row++;
        }
        row = i;
        int len = 0;
        while(col<n&&board[row][col]=='X'){
            len++;
            size[0] = Math.max(size[0], getHeight(board, row, col));
            col++;
        }
        size[1] = Math.max(size[1] , len);
        return size;
    }

    private int getLength(char[][] board, int i, int j){
        int length = 0;
        while(j<board[0].length&&board[i][j]=='X'){
            length++;
            j++;
        }
        return length;
    }
    private int getHeight(char[][] board, int i, int j){
        int height = 0;
        while(i<board.length&&board[i][j]=='X'){
            height++;
            i++;
        }
        return height;
    }

    /*
    If we do not have to consider the invalid ship:
    Going over all cells, we can count only those that are the “first” cell of the battleship.
    First cell will be defined as the most top-left cell.
    We can check for first cells by only counting cells that do not have an ‘X’ to the left and do not have an ‘X’ above them.
     */
    public int countBattleships2(char[][] board) {
        int m = board.length;
        if (m==0) return 0;
        int n = board[0].length;

        int count=0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue;
                count++;
            }
        }

        return count;
    }
}
