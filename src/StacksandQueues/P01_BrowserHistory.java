package StacksandQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque <String> sites = new ArrayDeque<>();

        while (!input.equals("Home")){

            if (input.equals("back")){
                if (sites.size()<=1){
                    System.out.println("no previous URLs");
                }else {
                    sites.pop();
                    String back = sites.peek();
                    System.out.println(back);
                }
            }
            else {
                sites.push(input);
                System.out.println(input);
            }

            input = scanner.nextLine();
        }

    }
}
