package am.iunetworks.training.sudoku.logic;
/**
 * This class contains all board manipulations.
 *  - Rotate
 *  - Switch columns & rows
 *  - Re-arrange
 *  - others
 * Created by Gurgen Nersesyan on 01.02.2015.
 */
public class GameBoardManipulationsHelper {

    private char[] board;




  public GameBoardManipulationsHelper(String board) {
        checkIsBoardValid(board);
        this.board = board.toCharArray();
    }

      private void checkIsBoardValid(String board) {
        if (board == null) {
            throw new NullPointerException("Game board can't be null");
        }
        if (board.length() != 81) {
            throw new IllegalArgumentException("Game board must be 81 chars long");
        }

        if (!board.matches("^\\d{81}$")) {
            throw new IllegalArgumentException("Game board can only have 0-9 chars");
        }
    }




    //Row switch or replace manipulation
    public  char[] switchRow(int a,int b){
        int range = a;
        int range2 = b;

        int length=9;

        char [][] matrix =new char[length][length];
        char [][] temp =new char[length][length];
        int index= 0;

        for (int i = 0; i < length;i++ ){
            for(int j = 0; j < length; j++) {
                temp[i][j] = board[index];
                index++;

            }
        }

        int index2=0;
        for (int i = 0; i < length;i++ ){
            for(int j = 0; j < length; j++) {
                if (j == range  ||  j==range2){
                    matrix [i][range]=temp[i][range2];
                    matrix [i][range2]=temp[i][range];

                }
                else{ matrix [i][j]=temp[i][j]; }

                board[index2] = matrix[i][j];
                index2++;

            }

        }

        return board;}



}
