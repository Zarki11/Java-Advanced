package Matrix;

import java.util.Scanner;

public class FillMatrixAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String matrixInfo = scanner.nextLine();
        String pattern = matrixInfo.split(", ")[1];
        int matrixSize = Integer.parseInt(matrixInfo.split(", ")[0]);
        int[][] matrix = new int[matrixSize][matrixSize];

        if (pattern.startsWith("A")){
            fillMatrixPatternA(matrix, matrixSize);
        } else if (pattern.startsWith("B")) {
            fillMatrixPatternB(matrix, matrixSize);
        }
        printMatrix(matrix);


    }

    private static void printMatrix(int[][] matrix) {

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix.length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternA(int[][] matrix, int matrixSize) {

        int startingNum = 1;
        for (int cols = 0; cols < matrixSize; cols++) {
            for (int rows = 0; rows < matrixSize; rows++) {
                matrix[rows][cols] = startingNum;
                startingNum++;
            }
        }
    }

    private static void fillMatrixPatternB(int[][] matrix, int matrixSize) {

        int startingNum = 1;
        for (int cols = 0; cols < matrixSize; cols++) {
            if (cols % 2 == 0) {
                for (int rows = 0; rows < matrixSize; rows++) {
                    matrix[rows][cols] = startingNum;
                    startingNum++;
                }
            }else {
                for (int rows = matrixSize-1 ; rows >= 0; rows--) {
                    matrix[rows][cols] = startingNum;
                    startingNum++;
                }
            }
        }
    }
}
