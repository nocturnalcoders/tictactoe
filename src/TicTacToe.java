class TicTacToe {
    private char[][] board;
    private int size;

    public TicTacToe(int size) {
        this.size = size;
        this.board = new char[size][size];
        initializeBoard();
    }

    public int getSize() {
        return size;
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row, int col, char player) {
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == '-') {
            board[row][col] = player;
            return true;
        } else {
            System.out.println("Invalid move. Try again.");
            return false;
        }
    }

    public boolean checkWin(char player) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < size; i++) {
            if (checkRow(i, player) || checkColumn(i, player) || checkDiagonals(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRow(int row, char player) {
        for (int i = 0; i < size; i++) {
            if (board[row][i] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, char player) {
        for (int i = 0; i < size; i++) {
            if (board[i][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonals(char player) {
        boolean diagonal1 = true;
        boolean diagonal2 = true;

        for (int i = 0; i < size; i++) {
            if (board[i][i] != player) {
                diagonal1 = false;
            }

            if (board[i][size - 1 - i] != player) {
                diagonal2 = false;
            }
        }

        return diagonal1 || diagonal2;
    }
}