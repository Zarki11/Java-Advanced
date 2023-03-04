package ExamPreparation;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int commandsNumber = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            char[] row = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = row;
        }
        int playerRow = 0, playerCol = 0, finalRow = 0, finalCol = 0;

        for (int i = 0; i < matrixSize; i++) {
            char[] chars = matrix[i];
            for (int j = 0; j < matrixSize; j++) {
                char currentChar = chars[j];
                if (currentChar == 'f') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
        boolean isFinal = false;

        for (int i = 0; i < commandsNumber; i++) {
            String command = scanner.nextLine();

            if (command.equals("up")) {

                if (playerRow == 0) {
                    playerRow = matrix.length - 1;
                    if (matrix[playerRow][playerCol] == 'B') {
                        playerRow--;
                    }
                    if (matrix[playerRow][playerCol] == 'T') {
                        playerRow++;
                    }
                } else {
                    playerRow--;
                    if (matrix[playerRow][playerCol] == 'T') {
                        playerRow++;
                    }
                    if (matrix[playerRow][playerCol] == 'B') {
                        playerRow--;
                    }
                }
                if (matrix[playerRow][playerCol] == 'F') {
                    isFinal = true;
                    break;
                }
            } else if (command.equals("down")) {
                if (playerRow == matrix.length - 1) {
                    playerRow = 0;
                    if (matrix[playerRow][playerCol] == 'B') {
                        playerRow++;
                    }
                    if (matrix[playerRow][playerCol] == 'T') {
                        playerRow--;
                    }
                } else {
                    playerRow++;
                    if (matrix[playerRow][playerCol] == 'T') {
                        playerRow--;
                    }
                    if (matrix[playerRow][playerCol] == 'B') {
                        playerRow++;
                    }
                }
                if (matrix[playerRow][playerCol] == 'F') {
                    isFinal = true;
                    break;
                }
            } else if (command.equals("left")) {
                if (playerCol == 0) {
                    playerCol = matrix.length - 1;
                    if (matrix[playerRow][playerCol] == 'B') {
                        playerCol--;
                    }
                    if (matrix[playerRow][playerCol] == 'T') {
                        playerCol++;
                    }
                } else {
                    playerCol--;
                    if (matrix[playerRow][playerCol] == 'T') {
                        playerCol++;
                    }
                    if (matrix[playerRow][playerCol] == 'B') {
                        playerCol--;
                    }
                }
                if (matrix[playerRow][playerCol] == 'F') {
                    isFinal = true;
                    break;
                }
            } else if (command.equals("right")) {
                if (playerCol == matrix.length - 1) {
                    playerCol = 0;
                    if (matrix[playerRow][playerCol] == 'B') {
                        playerCol++;
                    }
                    if (matrix[playerRow][playerCol] == 'T') {
                        playerCol--;
                    }
                } else {
                    playerCol++;
                    if (matrix[playerRow][playerCol] == 'T') {
                        playerCol--;
                    }
                    if (matrix[playerRow][playerCol] == 'B') {
                        playerCol++;
                    }
                }
                if (matrix[playerRow][playerCol] == 'F') {
                    isFinal = true;
                    break;
                }
            }
        }
        matrix[playerRow][playerCol] = 'f';

        if (isFinal){
            System.out.println("Player won!");
        }else {
            System.out.println("Player lost!");
        }
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
