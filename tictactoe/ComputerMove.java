package tictactoe;

import java.util.ArrayList;
import java.util.List;

import static tictactoe.Main.board;
import static tictactoe.Main.rand;

public class ComputerMove {
    static void computerMove(){
        List<int[]> emptyCells = new ArrayList<>();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == ' ') {
                    emptyCells.add(new int[]{i, j});
                }
            }
        }
        int[] move = emptyCells.get(rand.nextInt(emptyCells.size()));
        board[move[0]][move[1]] = 'O';
    }
}
