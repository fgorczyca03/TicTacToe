package ttt;

import java.util.Scanner;

public class TicTacToe {
  private static char[][] board = new char[3][3];
  private static char currentPlayer = 'X';

  public static void main(String[] args) {
    initializeBoard();
    printBoard();
    while (true) {
      makeMove();
      printBoard();
      if (checkWinner()) {
        System.out.println("Player " + currentPlayer + " wins!");
        break;
      }
      if (isBoardFull()) {
        System.out.println("It's a tie!");
        break;
      }
      switchPlayer();
    }
  }

  private static void initializeBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = '-';
      }
    }
  }

  private static void printBoard() {
    System.out.println("-------------");
    for (int i = 0; i < 3; i++) {
      System.out.print("| ");
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j] + " | ");
      }
      System.out.println();
      System.out.println("-------------");
    }
  }

  private static void makeMove() {
    Scanner scanner = new Scanner(System.in);
    int row, col;
    while (true) {
      System.out.print("Player " + currentPlayer + ", enter row (0-2): ");
      row = scanner.nextInt();
      System.out.print("Player " + currentPlayer + ", enter column (0-2): ");
      col = scanner.nextInt();
      if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
        break;
      } else {
        System.out.println("Invalid move! Please try again.");
      }
    }
    board[row][col] = currentPlayer;
    scanner.close();
  }

  private static boolean checkWinner() {
    // Check rows, columns, and diagonals for a win
    for (int i = 0; i < 3; i++) {
      if (board[i][0] == currentPlayer && board[i][1] == currentPlayer
          && board[i][2] == currentPlayer) {
        return true; // Row win
      }
      if (board[0][i] == currentPlayer && board[1][i] == currentPlayer
          && board[2][i] == currentPlayer) {
        return true; // Column win
      }
    }
    if (board[0][0] == currentPlayer && board[1][1] == currentPlayer
        && board[2][2] == currentPlayer) {
      return true; // Diagonal win
    }
    if (board[0][2] == currentPlayer && board[1][1] == currentPlayer
        && board[2][0] == currentPlayer) {
      return true; // Diagonal win
    }
    return false;
  }

  private static boolean isBoardFull() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == '-') {
          return false;
        }
      }
    }
    return true;
  }

  private static void switchPlayer() {
    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
  }
}
