import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Configure the game size
        System.out.print("Enter the size of the Tic-Tac-Toe board (e.g., 3 for a 3x3 board): ");
        int size = scanner.nextInt();

        TicTacToe game = new TicTacToe(size);

        char currentPlayer = 'X';

        while (true) {
            game.printBoard();
            System.out.println("Player " + currentPlayer + "'s turn.");

            System.out.print("Enter row (0-" + (size - 1) + "): ");
            int row = scanner.nextInt();

            System.out.print("Enter column (0-" + (size - 1) + "): ");
            int col = scanner.nextInt();

            if (game.makeMove(row, col, currentPlayer)) {
                if (game.checkWin(currentPlayer)) {
                    game.printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (isBoardFull(game)) {
                    game.printBoard();
                    System.out.println("It's a tie!");
                    break;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }

        scanner.close();
    }

    private static boolean isBoardFull(TicTacToe game) {
        for (int i = 0; i < game.getSize(); i++) {
            for (int j = 0; j < game.getSize(); j++) {
                if (game.getBoard()[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}


