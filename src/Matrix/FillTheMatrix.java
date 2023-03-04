package Matrix;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int matrixSize = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int [][] matrix = new int [matrixSize][matrixSize];
        int startingNumber = 1;
        if (pattern.equals("A")){
            for (int col = 0; col <matrix.length ; col++) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = startingNumber;
                    startingNumber++;
                }
            }

        }
        int startingNum = 1;
        if(pattern.equals("B")){

            for (int col = 0; col < matrix.length; col++) {
                if((col + 1) % 2 ==0){
                    for (int row = matrix.length-1; row >=0 ; row--) {
                        matrix[row][col] = startingNum;
                        startingNum++;
                    }
                }else {
                    for (int row = 0; row <matrix.length ; row++) {
                        matrix[row][col] = startingNum;
                        startingNum++;
                    }
                }
            }

        }
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }
    }
}
