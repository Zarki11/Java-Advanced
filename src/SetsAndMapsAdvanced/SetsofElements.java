package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsofElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstSetSize = scanner.nextInt();
        int secondSetSize = scanner.nextInt();

        Set <Integer> firstSet = new LinkedHashSet<>();
        Set <Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(scanner.nextInt());
        }
        for (int j = 0; j < secondSetSize; j++) {
            secondSet.add(scanner.nextInt());
        }


        firstSet.retainAll(secondSet);

        firstSet.forEach(el -> System.out.print(el + " "));
    }
}
