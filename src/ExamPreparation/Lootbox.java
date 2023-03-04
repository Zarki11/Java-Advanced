package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondStack = new ArrayDeque<>();

        List<Integer> firstBox = Arrays.stream(scanner.nextLine().split(" ")).map(el -> Integer.parseInt(el)).collect(Collectors.toList());
        List<Integer> secondBox = Arrays.stream(scanner.nextLine().split(" ")).map(el -> Integer.parseInt(el)).collect(Collectors.toList());

        for (int el : firstBox) {
            firstQueue.offer(el);
        }
        for (int el : secondBox) {
            secondStack.push(el);
        }

        int sum = 0;
        int loop = 0;
        while (!firstQueue.isEmpty() && !secondStack.isEmpty()) {

            if (firstQueue.peek() + secondStack.peek() % 2 == 0) {
                int firstBoxEl = firstQueue.peek();
                int secondBoxEl = secondStack.peek();
                sum += firstBoxEl + secondBoxEl;
                loop += sum;
                firstQueue.poll();
                secondStack.pop();
            } else if (firstQueue.peek() + secondStack.peek() % 2 != 0) {
                int secondBoxEl = secondStack.peek();
                secondStack.pop();
                firstQueue.offer(secondBoxEl);
            }
        }

        if (firstQueue.isEmpty()){
            System.out.println("First lootbox is empty");
        } else if (secondStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (sum >= 100){
            System.out.printf("Your loot was epic! Value: %d", loop);
        }else {
            System.out.printf("Your loot was poor... Value: %d", loop);
        }
    }
}
