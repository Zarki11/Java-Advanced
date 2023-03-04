package Matrix;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);

        String [][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();
        while (!command.equals("END")){

            boolean isValid = true;
            String [] commandParts = command.split(" ");

            if (commandParts.length != 5){
                isValid = false;
            }
            if (!commandParts[0].equals("swap")){
                isValid = false;
            }
            int row1 = 0;
            int col1 = 0;
            int row2 = 0;
            int col2 = 0;

            if (commandParts.length == 5) {
                row1 = Integer.parseInt(commandParts[1]);
                col1 = Integer.parseInt(commandParts[2]);

                row2 = Integer.parseInt(commandParts[3]);
                col2 = Integer.parseInt(commandParts[4]);
            }

            if (row1<0 || row1>= matrix.length || col1 < 0 || col1 >= cols || row2<0 || row2>= matrix.length || col2 < 0 || col2 >= cols){
                isValid = false;
            }
            if (isValid){
                String firstSwapCell = matrix[row1][col1];
                String secondSwapCell = matrix[row2][col2];

                matrix[row1][col1] = secondSwapCell;
                matrix[row2][col2] = firstSwapCell;

                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[0].length; col++) {
                        System.out.print(matrix[row][col] + " ");
                    }
                    System.out.println();
                }
            } 
            else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    public static void fillMatrix(String [][] matrix, Scanner scanner){

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }


    }
    
    

}
