public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
     public void printBoard() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    public boolean placeSymbol(int row, int col, char symbol) {
        if (board[row][col] == '-') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }
    public char[][] getBoard() {
        return board;
    }
}
