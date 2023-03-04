package StackAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsNum = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder();
        ArrayDeque <String> stack = new ArrayDeque<>();

        for (int i = 0; i < commandsNum; i++) {
            String[] commandData = scanner.nextLine().split(" ");
            int command = Integer.parseInt(commandData[0]);

            if (command == 1) {
                sb.append(commandData[1]);
                stack.push(sb.toString());

            } else if (command == 2) {
                int toRemove = Integer.parseInt(commandData[1]);
                int sizeSb = sb.length();
                int startIndex = sizeSb - toRemove;

                sb.delete(startIndex, sizeSb);
                if (!sb.isEmpty()){
                stack.push(sb.toString());
                }
            } else if (command == 3) {
                int toPrint = Integer.parseInt(commandData[1]);
                System.out.println(sb.charAt(toPrint -1));

            } else if (command == 4) {
                if (!stack.isEmpty()) {
                    String last = stack.pop();
                    sb = new StringBuilder(last);
                }
            }

        }


    }
}
