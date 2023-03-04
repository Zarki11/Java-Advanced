package ExamPreparation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");
        int matrixSizeRow = Integer.parseInt(size[0]);
        int matrixSizeCol = Integer.parseInt(size[1]);
        int myYRow = 0;
        int myYCol = 0;
        int treasureRow = 0;
        int treasureCol = 0;

        char[][] matrix = new char[matrixSizeRow][matrixSizeCol];

        for (int i = 0; i < matrix.length; i++) {
            char[] row = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = row;
        }

        for (int i = 0; i < matrix.length; i++) {
            char[] chars = matrix[i];
            for (int j = 0; j < chars.length; j++) {
                char currentChar = chars[j];
                if (currentChar == 'Y') {
                    myYRow = i;
                    myYCol = j;
                }
                if (currentChar == 'X') {
                    treasureRow = i;
                    treasureCol = j;
                }
            }
        }

        List<String> directions = new LinkedList<>();
        String command = scanner.nextLine();
        while (!command.equals("Finish")) {

            switch (command) {
                case "up":
                    if (myYRow != 0 && matrix[myYRow - 1][myYCol] != 'T') {
                        directions.add(command);
                        myYRow--;
                    }
                    break;
                case "down":
                    if (myYRow != matrixSizeRow - 1 && matrix[myYRow + 1][myYCol] != 'T') {
                        directions.add(command);
                        myYRow++;
                    }
                    break;
                case "left":
                    if (myYCol != 0 && matrix[myYRow][myYCol - 1] != 'T') {
                        directions.add(command);
                        myYCol--;
                    }
                    break;
                case "right":
                    if (myYCol != matrixSizeCol - 1 && matrix[myYRow][myYCol + 1] != 'T') {
                        directions.add(command);
                        myYCol++;
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        if (myYRow == treasureRow && myYCol == treasureCol){
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            String paths = String.join(", ", directions);
            System.out.println(paths);
        }
        else {
            System.out.println("The map is fake!");
        }

    }
}
