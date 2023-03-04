package StackAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int size = input.length();

        if (size % 2 != 0){
            System.out.println("NO");
            return;
        }
        ArrayDeque <Character> stackOpen = new ArrayDeque<>();
        ArrayDeque <Character> queueClosing = new ArrayDeque<>();

        for (int openBr = 0; openBr < size / 2; openBr++) {
            stackOpen.push(input.charAt(openBr));
        }
        for (int closeBr = size / 2; closeBr < size; closeBr++) {
            queueClosing.offer(input.charAt(closeBr));
        }
        while (stackOpen.size()!=0){
            if (stackOpen.peek().equals('(')){
                if (!queueClosing.peek().equals(')')){
                    System.out.println("NO");
                    return;
                }else {
                    stackOpen.pop();
                    queueClosing.poll();
                }
            }
            if (stackOpen.size()==0){
                break;
            }
            if (stackOpen.peek().equals('{')){
                if (!queueClosing.peek().equals('}')){
                    System.out.println("NO");
                    return;
                }else {
                    stackOpen.pop();
                    queueClosing.poll();
                }
            }if (stackOpen.size()==0){
                break;}
            if (stackOpen.peek().equals('[')){
                if (!queueClosing.peek().equals(']')){
                    System.out.println("NO");
                    return;
                }else {
                    stackOpen.pop();
                    queueClosing.poll();
                }
            }
        }
        System.out.println("YES");


    }
}
