package java;

import java.util.HashSet;

/**
 * Created by haileyyin on 11/13/17.
 */
public class ValidSudoku {

    /*
    brutal force
     */
    public boolean isValidSudoku1(char[][] board) {
        if(board.length!=9 || board[0].length!=9){
            return false;
        }

        HashSet<Integer> hset = new HashSet<>(9);
        hset.add(1);
        hset.add(2);
        hset.add(3);
        hset.add(4);
        hset.add(5);
        hset.add(6);
        hset.add(7);
        hset.add(8);
        hset.add(9);

        //check each row
        for(int i=0; i<board.length; i++){
            HashSet<Integer> rowSet = new HashSet<>(hset);
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]!='.' && !rowSet.contains(board[i][j]-'0')){
                    return false;
                }
                rowSet.remove(board[i][j]-'0');
            }
        }
        //check each column
        for(int i=0; i<board[0].length; i++){
            HashSet<Integer> columnSet = new HashSet<>(hset);
            for(int j=0; j<board.length; j++){
                if(board[j][i]!='.' && !columnSet.contains(board[j][i]-'0')){
                    return false;
                }
                columnSet.remove(board[j][i]-'0');
            }
        }
        //check each box
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                HashSet<Integer> boxSet = new HashSet<>(hset);
                int rowNum = 3*i;
                int columnNum = 3*j;
                for(int k=rowNum; k<rowNum+3; k++){
                    for(int m=columnNum; m<columnNum+3; m++){
                        if(board[k][m]!='.' && !boxSet.contains(board[k][m]-'0')){
                            return false;
                        }
                        boxSet.remove(board[k][m]-'0');
                    }
                }
            }
        }
        return true;
    }

    /*
    update: from discussion
     */
    public boolean isValidSudoku2(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }
}
