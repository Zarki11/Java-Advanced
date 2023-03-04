package ExamPreparation;

import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];
        int rowS = 0, colS = 0, firstPillarRow = -1, firstPillarCol = -1, secondPillarRow = -1, secondPillarCol = -1;


        for (int rows = 0; rows < matrixSize; rows++) {
            char[] row = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[rows] = row;
        }

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {

                if (matrix[i][j] == 'S') {
                    rowS = i;
                    colS = j;
                } else if (matrix[i][j] == 'O') {
                    if (firstPillarRow == -1) {
                        firstPillarRow = i;
                        firstPillarCol = j;
                    } else {
                        secondPillarRow = i;
                        secondPillarCol = j;
                    }
                }
            }
        }

        int enoughMoney = 50, myMoney = 0;
        while (rowS > -1 && rowS < matrixSize && colS > -1 && colS < matrixSize && myMoney < 50) {
            String command = scanner.nextLine();
            int lastSRow = rowS;
            int lastSCol = colS;

            switch (command) {
                case "up":
                    rowS--;
                    if (rowS == firstPillarRow && colS == firstPillarCol) {
                        matrix[lastSRow][lastSCol] = '-';
                        rowS = secondPillarRow;
                        colS = secondPillarCol;
                        matrix[lastSRow][lastSCol] = '-';
                        matrix[rowS][colS] = 'S';
                    } else if (rowS == secondPillarRow && colS == secondPillarCol) {
                        matrix[lastSRow][lastSCol] = '-';
                        rowS = firstPillarRow;
                        colS = firstPillarCol;
                        matrix[lastSRow][lastSCol] = '-';
                        matrix[rowS][colS] = 'S';

                    } else if (matrix[rowS][colS] == '-') {

                    } else {
                        //myMoney += Integer.parseInt(matrix[rowS][colS]);
                    }
                    break;
                case "down":
                    rowS++;
                    break;
                case "left":
                    colS--;
                    break;
                case "right":
                    colS++;
                    break;
            }


        }

    }

}
