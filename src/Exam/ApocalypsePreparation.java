package Exam;

import java.util.*;
import java.util.stream.Collectors;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstTextilesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondMedicamentsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(firstTextilesQueue::offer);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(secondMedicamentsStack::push);

        int patch = 30, bandage = 40, medKit = 100;
        int patchCounter = 0, bandageCounter = 0, medKitCounter = 0;
        HashMap<String, Integer> map = new HashMap<>();

        while (!firstTextilesQueue.isEmpty() && !secondMedicamentsStack.isEmpty()) {
            int mix = firstTextilesQueue.peek() + secondMedicamentsStack.peek();

            if (mix == patch) {
                removeElements(firstTextilesQueue, secondMedicamentsStack);
                patchCounter++;
            } else if (mix == bandage) {
                removeElements(firstTextilesQueue, secondMedicamentsStack);
                bandageCounter++;
            } else if (mix == medKit) {
                removeElements(firstTextilesQueue, secondMedicamentsStack);
                medKitCounter++;
            } else if (mix > medKit) {
                removeElements(firstTextilesQueue, secondMedicamentsStack);
                int toAdd = secondMedicamentsStack.pop();
                int sum = mix - medKit;
                secondMedicamentsStack.push(toAdd + sum);
                medKitCounter++;
            } else {
                firstTextilesQueue.poll();
                int backToPlace = secondMedicamentsStack.pop();
                secondMedicamentsStack.push(backToPlace + 10);
            }
        }
        if (medKitCounter > 0) {
            map.put("MedKit", medKitCounter);
        }
        if (bandageCounter > 0) {
            map.put("Bandage", bandageCounter);
        }
        if (patchCounter > 0) {
            map.put("Patch", patchCounter);
        }

        if (firstTextilesQueue.isEmpty() && secondMedicamentsStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (firstTextilesQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if (secondMedicamentsStack.isEmpty()) {
            System.out.println("Medicaments are empty.");
        }

        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(el -> System.out.println(el.getKey() + " - " + el.getValue()));


        if (!secondMedicamentsStack.isEmpty()){
            System.out.print("Medicaments left: ");
            String casing = secondMedicamentsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(casing);
        }
        if (!firstTextilesQueue.isEmpty()){
            System.out.print("Textiles left: ");
            String effect = firstTextilesQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(effect);
        }
    }

    private static void removeElements(ArrayDeque<Integer> firstTextilesQueue, ArrayDeque<Integer> secondMedicamentsStack) {
        firstTextilesQueue.poll();
        secondMedicamentsStack.pop();
    }
}
