package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        int biscuit = 25;
        int cake = 50;
        int pastry = 75;
        int pie = 100;
        int biscuitCounter = 0, cakeCounter = 0, pastryCounter = 0, pieCounter = 0;

        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(liquidsQueue::offer);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(ingredientsStack::push);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            boolean isValid = true;

            int myPoints = ingredientsStack.peek() + liquidsQueue.peek();
            if (myPoints != 25 && myPoints != 50 && myPoints != 75 && myPoints != 100) {

                liquidsQueue.poll();
                int variable = ingredientsStack.pop() + 3;
                ingredientsStack.push(variable);
                isValid = false;
            }
            
            if (isValid) {

                if (myPoints == biscuit) {
                    biscuitCounter++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                } else if (myPoints == cake) {
                    cakeCounter++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                } else if (myPoints == pastry) {
                    pastryCounter++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                } else if (myPoints == pie) {
                    pieCounter++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                }
            }
        }
        if (biscuitCounter > 0 && cakeCounter > 0 && pastryCounter > 0 && pieCounter > 0){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquidsQueue.isEmpty()){
            System.out.println("Liquids left: none");
        }else {
            System.out.print("Liquids left: ");
            for (int i = 0; i <= liquidsQueue.size(); i++) {
                if (liquidsQueue.peek().equals(liquidsQueue.size())){
                    System.out.println(liquidsQueue.peek());
                }else {
                    System.out.print(liquidsQueue.poll() + ", ");
                }
            }
        }
        if (ingredientsStack.isEmpty()){
            System.out.println("Ingredients left: none");
        }else {
            System.out.print("Ingredients left: ");
            for (int i = 0; i <= ingredientsStack.size(); i++) {
                if (ingredientsStack.peek().equals(ingredientsStack.size())){
                    System.out.println(ingredientsStack.peek());
                }else {
                    System.out.print(ingredientsStack.pop() + ", ");
                }
            }
        }
        System.out.printf("Biscuit: %d%nCake: %d%nPie: %d%nPastry: %d", biscuitCounter, cakeCounter, pieCounter, pastryCounter);
    }
}
