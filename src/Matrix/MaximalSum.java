package Matrix;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int [][] matrix = new int[rows][cols];

        fillMatrix(matrix, scanner, rows, cols);


        int startRow = 0;
        int startCol = 0;

        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < rows-2; row++) {
            for (int col = 0; col < cols-2; col++) {
                int sum = matrix[row][col] + matrix[row][col+1] + matrix[row][col+2] + matrix[row+1][col] + matrix[row+1][col+1]
                        + matrix [row+1][col+2] + matrix [row+2][col] + matrix[row+2][col+1] + matrix[row+2][col+2];
                if (sum > maxSum){
                    maxSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }
        System.out.printf("Sum = %d", maxSum);
        for (int row = startRow; row < startRow+2; row++) {
            for (int i = startCol; i < startCol+2; i++) {
                System.out.println(matrix[row][i] + " ");
            }
            System.out.println();
        }

    }

    public static void fillMatrix(int [][] matrix, Scanner scanner, int rows, int cols){

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }


}
