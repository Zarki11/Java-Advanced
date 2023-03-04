package ExamPreparation;

import java.util.*;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque <Integer> stackTulips = new ArrayDeque<>();
        ArrayDeque <Integer> queueDaffodils = new ArrayDeque<>();
        int bouquet = 15,neededBouquet = 5, bouquetCounter = 0;
        int leftFlowers = 0;

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(stackTulips::push);
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(queueDaffodils::offer);

        while (!stackTulips.isEmpty() && !queueDaffodils.isEmpty()){
            int mix = stackTulips.peek() + queueDaffodils.peek();

            if (mix == bouquet){
                queueDaffodils.poll();
                stackTulips.pop();
                bouquetCounter++;
            } else if (mix > bouquet) {
                int toDecrease = stackTulips.pop() - 2;
                stackTulips.push(toDecrease);
            }else {
               leftFlowers += mix;
               stackTulips.pop();
               queueDaffodils.poll();
            }
        }
        bouquetCounter += leftFlowers / bouquet;

        if (bouquetCounter >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquetCounter);
        }else {
            System.out.printf("You failed... You need more %d bouquets.", neededBouquet - bouquetCounter);
        }
    }
}
