package Matrix;

import java.util.Scanner;

public class MatrixShufflingAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);
        String[][] matrix = new String[rows][cols]; 

        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();

        while (!command.equals("END")){
            String[] commandInfo = command.split(" ");
            boolean isValid = true;

            if (commandInfo.length != 5 || !commandInfo[0].equals("swap")){
                isValid = false;
            }
            int row1 = 0;
            int col1 = 0;

            int row2 = 0;
            int col2 = 0;

            if (isValid){
                row1 = Integer.parseInt(commandInfo[1]);
                col1 = Integer.parseInt(commandInfo[2]);
                row2 = Integer.parseInt(commandInfo[3]);
                col2 = Integer.parseInt(commandInfo[4]);
            }
            if (row1 < 0 || row1 >= rows || col1 < 0 || col1 >= cols || row2 < 0 || row2 >= rows || col2 < 0 || col2 >= cols){
                isValid = false;
            }
            if (isValid){
                String firstSwapCell = matrix[row1][col1];
                String secondSwapCell = matrix[row2][col2];

                matrix[row1][col1] = secondSwapCell;
                matrix[row2][col2] = firstSwapCell;

                printMatrix(matrix);
            }
            if (!isValid){
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[0].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length ; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
    }
}
