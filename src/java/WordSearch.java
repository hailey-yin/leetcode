package java;

/**
 * Created by haileyyin on 1/10/18.
 */
public class WordSearch {
    /*
    recursion
    */
    public boolean exist(char[][] board, String word) {
        for(int i=0 ; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(exist(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int x, int y, int idx){
        if(idx==word.length())
            return true;
        if(x<0 || x>board.length-1 || y<0 || y>board[0].length-1 || board[x][y]!=word.charAt(idx))
            return false;
        board[x][y] = '*';
        boolean flag = exist(board, word, x-1, y, idx+1)
                || exist(board, word, x, y-1, idx+1)
                || exist(board, word, x+1, y, idx+1)
                || exist(board, word, x, y+1, idx+1);
        board[x][y] = word.charAt(idx);
        return flag;
    }
}
