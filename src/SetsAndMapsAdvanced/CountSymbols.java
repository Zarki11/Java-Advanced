package SetsAndMapsAdvanced;

import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map <Character, Integer> countMap = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (!countMap.containsKey(currentSymbol)){
                countMap.put(currentSymbol, 1);
            }
            else {
                int currentValue = countMap.get(currentSymbol);
                currentValue++;
                countMap.put(currentSymbol, currentValue);
            }
        }
        countMap.entrySet().forEach(el -> System.out.println(el.getKey() + ": " + el.getValue() + " time/s"));
    }
}
