package Exam;

import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        int myBRow = 0;
        int myBCol = 0;
        char[][] matrix = new char[n][m];

        for (int i = 0; i < matrix.length; i++) {
            char[] row = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = row;
        }
        for (int i = 0; i < matrix.length; i++) {
            char[] chars = matrix[i];
            for (int j = 0; j < chars.length; j++) {
                char currentChar = chars[j];
                if (currentChar == 'B') {
                    myBRow = i;
                    myBCol = j;
                }
            }
        }

        int touchedPlayers = 0, moves = 0;
        String command = scanner.nextLine();

        while (!command.equals("Finish") && touchedPlayers < 3) {

            if (command.equals("up")) {
                if (myBRow != 0 && matrix[myBRow - 1][myBCol] != 'O') {
                    myBRow--;
                    moves++;
                }
                if (matrix[myBRow][myBCol] == 'P'){
                    matrix[myBRow][myBCol] = '-';
                    touchedPlayers++;
                }
            } else if (command.equals("down")) {
                if (myBRow != n - 1 && matrix[myBRow + 1][myBCol] != 'O') {
                    myBRow++;
                    moves++;
                }
                if (matrix[myBRow][myBCol] == 'P'){
                    matrix[myBRow][myBCol] = '-';
                    touchedPlayers++;
                }
            } else if (command.equals("left")) {
                if (myBCol != 0 && matrix[myBRow][myBCol - 1] != 'O') {
                    myBCol--;
                    moves++;
                }
                if (matrix[myBRow][myBCol] == 'P'){
                    matrix[myBRow][myBCol] = '-';
                    touchedPlayers++;
                }
            } else if (command.equals("right")) {
                if (myBCol != m - 1 && matrix[myBRow][myBCol + 1] != 'O') {
                    myBCol++;
                    moves++;
                }
                if (matrix[myBRow][myBCol] == 'P'){
                    matrix[myBRow][myBCol] = '-';
                    touchedPlayers++;
                }
            }
            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchedPlayers, moves);

    }
}
