package StackAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_ReverseNumberswithaStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        ArrayDeque <Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(n);
        }



    }
}
