package StackAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque <Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }
        for (int j = 0; j < s; j++) {
            stack.pop();
        }
        if (stack.contains(x)){
            System.out.println("true");
        }
        else {
            if (stack.isEmpty()){
                System.out.println("0");
            }
            else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}
