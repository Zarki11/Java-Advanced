package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffectQueue = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasingStack = new ArrayDeque<>();

        int daturaBombs = 40, cherryBombs = 60, smokeDecoyBombs = 120;
        int daturaBombsCounter = 0;
        int cherryBombsCounter = 0;
        int smokeDecoyBombsCounter = 0;

        boolean isFull = false;

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(bombEffectQueue::offer);
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(bombCasingStack::push);

        while (!bombEffectQueue.isEmpty() && !bombCasingStack.isEmpty() && !isFull) {
            int toDecrease = bombCasingStack.peek();
            int mix = bombEffectQueue.peek() + bombCasingStack.peek();

            if (daturaBombsCounter >= 3 && cherryBombsCounter >= 3 && smokeDecoyBombsCounter >= 3) {
                isFull = true;
                continue;
            }

            if (mix == daturaBombs) {
                bombCasingStack.pop();
                bombEffectQueue.poll();
                daturaBombsCounter++;
            } else if (mix == cherryBombs) {
                bombCasingStack.pop();
                bombEffectQueue.poll();
                cherryBombsCounter++;
            } else if (mix == smokeDecoyBombs) {
                bombCasingStack.pop();
                bombEffectQueue.poll();
                smokeDecoyBombsCounter++;
            } else {
                bombCasingStack.pop();
                bombCasingStack.push(toDecrease - 5);
            }
        }
        if (isFull) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffectQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            String effect = bombEffectQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.print("Bomb Effects: ");
            System.out.println(effect);
        }
        if (bombCasingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            String casing = bombCasingStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.print("Bomb Casings: ");
            System.out.println(casing);
        }
        System.out.printf("Cherry Bombs: %d\n", cherryBombsCounter);
        System.out.printf("Datura Bombs: %d\n", daturaBombsCounter);
        System.out.printf("Smoke Decoy Bombs: %d\n", smokeDecoyBombsCounter);

    }
}
