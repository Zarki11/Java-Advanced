package ExamPreparation;

import java.util.*;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        int myPoints = 0;

        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(firstBoxQueue::offer);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(secondBoxStack::push);

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int mix = firstBoxQueue.peek() + secondBoxStack.peek();

            if (mix % 2 == 0) {
                myPoints += mix;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                int toRemove = secondBoxStack.pop();
                firstBoxQueue.offerLast(toRemove);
            }
        }

        if (secondBoxStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        } else if (firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (myPoints >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", myPoints);
        } else {
            System.out.printf("Poor prey... Value: %d", myPoints);
        }
    }
}
