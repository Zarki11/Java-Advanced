package StackAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayDeque <Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String comm = scanner.nextLine();
            if (comm.equals("2")){
                stack.pop();
            } else if (comm.equals("3")) {
                if (stack.size()>0){
                    System.out.println(Collections.max(stack));
                }
            }else {
                int toAdd = Integer.parseInt(comm.split("//s+")[1]);
                stack.push(toAdd);
            }

        }



    }
}
