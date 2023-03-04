package Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandDegrees = scanner.nextLine();
        int angleRotation = Integer.parseInt(commandDegrees.split("[()]+")[1]) % 360;
        List<String> allWords = new ArrayList<>();

        int maxLength = 0;
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("END")) {
                break;
            }
            allWords.add(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
        }
        int rows = allWords.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        rotate(matrix, rows, cols, allWords);
    }

    public static void rotate(char[][] matrix, int rows, int cols, List<String> allWOrds) {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = 1;
            }
        }
    }
}
