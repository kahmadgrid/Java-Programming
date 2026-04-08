package tictactoe;

import static tictactoe.Main.board;

public class CheckGame{
    static boolean checkGame(){

        if(checkWin('O')){
            System.out.println("O wins");
            return true;
        } else if (checkWin('X')) {
            System.out.println("X wins");
            return true;
        }
        else {
            int cnt =0;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(board[i][j] == ' ') cnt++;
                }
            }
            if(cnt != 0) return false;
            else {
                System.out.println("Draw");
                return true;
            }

        }
    }
    static boolean checkWin(char p) {

        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) return true;
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) return true;
        }

        // Diagonals
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) return true;
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) return true;

        return false;
    }
}
