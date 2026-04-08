package tictactoe;

import java.util.Scanner;

import static tictactoe.Main.board;
import static tictactoe.Validation.isNumber;

public class UserMove {
    static void userMove(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter the coordinates: ");
            String line = sc.nextLine();
            String[] parts = line.trim().split(" ");

            if(parts.length != 2) continue;

            if(!isNumber(parts[0]) || !isNumber(parts[1])) continue;

            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);

            if(row < 1 || row > 3 || col < 1 || col > 3) continue;

            row--;
            col--;
            if(board[row][col] != ' ') continue;
            board[row][col] = 'X';
            break;
        }
    }
}
