package Matrix;

import java.util.Scanner;

public class MatrixofPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] inputLine = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(inputLine[0]);
        int cols = Integer.parseInt(inputLine[1]);

        String [][] matrix = new String[rows][cols];
        
        fillMatrix(matrix, rows, cols);

        printMatrix(matrix, rows, cols);




    }

    public static void fillMatrix(String [][] matrix, int rows, int cols){
        char startChar = 'a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String palindrome = "" + startChar + (char)(startChar + col) + startChar;
                matrix[row][col] = palindrome;
            }
            startChar =(char)(startChar + 1);
        }
        
        
    }
    public static void printMatrix(String [][] matrix, int rows,int cols){
        for (int row= 0; row < rows ; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
