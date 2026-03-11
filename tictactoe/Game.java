import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    

    public Game(Player player1, Player player2) {
        board = new Board();
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        // Game loop and logic to handle turns, check for win/draw conditions
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = player1;

        while(true){
            board.printBoard();
            System.out.println(currentPlayer.getName() + "'s turn. Enter row and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            boolean moveSuccessful = board.placeSymbol(row, col, currentPlayer.getSymbol());
            if (!moveSuccessful) {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            // Check for win/draw conditions here (not implemented in this snippet)
            if(checkWinner(currentPlayer.getSymbol())){
                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }
            if(isBoardFull()){
                board.printBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;

        }
    }
    private boolean checkWinner(char symbol) {
        char[][] b = board.getBoard();
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (b[i][0] == symbol && b[i][1] == symbol && b[i][2] == symbol) {
                return true;
            }
            if (b[0][i] == symbol && b[1][i] == symbol && b[2][i] == symbol) {
                return true;
            }
        }
        if (b[0][0] == symbol && b[1][1] == symbol && b[2][2] == symbol) {
            return true;
        }
        if (b[0][2] == symbol && b[1][1] == symbol && b[2][0] == symbol) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        char[][] b = board.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    
}
