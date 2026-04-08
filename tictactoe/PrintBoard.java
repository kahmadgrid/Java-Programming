package tictactoe;

import static tictactoe.Main.board;

public class PrintBoard {
    static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print((board[i][j] == '_' ? ' ' : board[i][j]) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
