package ExamPreparation;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        int beeRow = 0;
        int beeCol = 0;

        for (int i = 0; i < n; i++) {
            char[] symbols = scanner.nextLine().toCharArray();
            matrix[i] = symbols;
        }

        for (int i = 0; i < n; i++) {
            char[] chars = matrix[i];
            for (int j = 0; j < n; j++) {
                char currentChar = chars[j];
                if (currentChar == 'B') {
                    beeRow = i;
                    beeCol = j;
                }
            }
        }



    }
}
