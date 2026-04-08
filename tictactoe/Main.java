package tictactoe;

import java.util.*;

import static tictactoe.CheckGame.checkGame;
import static tictactoe.ComputerMove.computerMove;
import static tictactoe.PrintBoard.printBoard;
import static tictactoe.UserMove.userMove;

public class Main {

    static char[][] board = new char[3][3];
    static Random rand = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }
        printBoard();

        while (true) {
            userMove();
            printBoard();

            if (checkGame()) break;

            System.out.println("Making move level \"easy\"");
            computerMove();
            printBoard();

            if (checkGame()) break;
        }

    }
}