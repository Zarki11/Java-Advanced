package SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Set <String> chemicals = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String chemical = scanner.nextLine();
            for (int j = 0; j < chemical.split(" ").length; j++) {
                chemicals.add(chemical.split(" ")[j]);
            }
        }

            chemicals.forEach(s -> System.out.print(s + " "));


    }
}
