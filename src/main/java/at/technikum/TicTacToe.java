package at.technikum;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            board.clear();
            Player currentPlayer = player1;
            board.print();
            boolean gameEnded = false;

            for (int moveCount = 0; moveCount < 9; moveCount++) {
                int x, y;
                while (true) {
                    System.out.println("Current Player: " + currentPlayer.getMarker());
                    System.out.print("row (0-2): ");
                    x = scanner.nextInt();
                    System.out.print("column (0-2): ");
                    y = scanner.nextInt();
                    if (x >= 0 && x < 3 && y >= 0 && y < 3 && board.isCellEmpty(x, y)) break;
                    System.out.println("Invalid move. Try again.");
                }

                board.place(x, y, currentPlayer.getMarker());
                System.out.println("Current game state after move:");
                board.print();

                if (board.hasWinner(currentPlayer.getMarker())) {
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    gameEnded = true;
                    break;
                }

                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }

            if (!gameEnded) {
                System.out.println("Game ended in a draw.");
            }

            System.out.print("Do you want to play again? (y/n): ");
            String answer = scanner.next().toLowerCase();
            playAgain = answer.equals("y");

        } while (playAgain);

        scanner.close();
    }

    public static void main(String[] args) {
        new TicTacToe().start();
    }
}


