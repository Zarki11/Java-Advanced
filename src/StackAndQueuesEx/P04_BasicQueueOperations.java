package StackAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numToAdd = scanner.nextInt();
        int numToRemove = scanner.nextInt();
        int numToSee = scanner.nextInt();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numToAdd; i++) {
            queue.offer(scanner.nextInt());
        }
        for (int j = 0; j < numToRemove; j++) {
            queue.poll();
        }
       if (queue.isEmpty()){
           System.out.println("0");
           return;
       }
       if (queue.contains(numToSee)){
           System.out.println("true");
       }
        else {
           System.out.println(Collections.min(queue));
       }
    }
}
