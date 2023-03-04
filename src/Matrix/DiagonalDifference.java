package Matrix;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[n][n];
        int primarySum = 0;
        int secondaryDiagonal = 0;

        fillMatrix(matrix, scanner);

        primarySum = primaryDiagonalSum(matrix);
        secondaryDiagonal = secondaryDiagonalSum(matrix);

        int diff = Math.abs(primarySum-secondaryDiagonal);
        System.out.println(diff);

    }
    public static void fillMatrix(int [][] matrix, Scanner scanner){

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

    }

    public static int primaryDiagonalSum(int [][] matrix){
        int primarySum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row==col){
                    primarySum += matrix[row][col];
                }
            }
        }
        return primarySum;

    }

    public static int secondaryDiagonalSum(int [][] matrix) {
        int secondarySum = 0;
        for (int row = 0; row <matrix.length ; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == matrix.length - row -1){
                    secondarySum += matrix[row][col];
                }
            }
        }
        return secondarySum;
    }
}
