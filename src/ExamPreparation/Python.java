package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        ArrayDeque<String> commandsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).forEach(commandsQueue::offer);
        int commandsNumber = commandsQueue.size();

        for (int i = 0; i < n; i++) {
            char[] row = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = row;
        }
        int mySRow = 0, mySCol = 0, food = 0, length = 1;

        for (int i = 0; i < matrix.length; i++) {
            char[] chars = matrix[i];
            for (int j = 0; j < chars.length; j++) {
                char currentChar = chars[j];

                if (currentChar == 's') {
                    mySRow = i;
                    mySCol = j;
                } else if (currentChar == 'f') {
                    food++;
                }
            }
        }

        for (int i = 0; i < commandsNumber; i++) {
            String command = commandsQueue.poll();

            if (command.equals("up")) {
                if (mySRow == 0) {
                    mySRow = matrix.length - 1;
                } else {
                    mySRow--;
                }
                if (matrix[mySRow][mySCol] == 'f') {
                    length++;
                    food--;
                    matrix[mySRow][mySCol] = '*';
                    if (food == 0) {
                        break;
                    }
                } else if (matrix[mySRow][mySCol] == 'e') {
                    break;
                }
            } else if (command.equals("down")) {
                if (mySRow == matrix.length - 1) {
                    mySRow = 0;
                } else {
                    mySRow++;
                }
                if (matrix[mySRow][mySCol] == 'f') {
                    length++;
                    food--;
                    matrix[mySRow][mySCol] = '*';
                    if (food == 0) {
                        break;
                    }
                } else if (matrix[mySRow][mySCol] == 'e') {
                    break;
                }
            } else if (command.equals("left")) {
                if (mySCol == 0) {
                    mySCol = matrix.length - 1;
                } else {
                    mySCol--;
                }
                if (matrix[mySRow][mySCol] == 'f') {
                    length++;
                    food--;
                    matrix[mySRow][mySCol] = '*';
                    if (food == 0) {
                        break;
                    }
                } else if (matrix[mySRow][mySCol] == 'e') {
                    break;
                }
            } else if (command.equals("right")) {
                if (mySCol == matrix.length - 1) {
                    mySCol = 0;
                } else {
                    mySCol++;
                }
                if (matrix[mySRow][mySCol] == 'f') {
                    length++;
                    food--;
                    matrix[mySRow][mySCol] = '*';
                    if (food == 0) {
                        break;
                    }
                } else if (matrix[mySRow][mySCol] == 'e') {
                    break;
                }
            }
        }
        if (food == 0) {
            System.out.printf("You win! Final python length is %d", length);
        } else if (food > 0 && matrix[mySRow][mySCol] != 'e') {
            System.out.printf("You lose! There is still %d food to be eaten.", food);
        } else {
            System.out.println("You lose! Killed by an enemy!");
        }
    }
}
