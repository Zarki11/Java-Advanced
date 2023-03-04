package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterbyAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map <String, Integer> humanData = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String [] data = scanner.nextLine().split(", ");
            humanData.put(data[0], Integer.parseInt(data[1]));
        }

        String condition = scanner.nextLine();
        int years = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate <Integer> filter = getFilter(condition, years);
        Consumer <Map.Entry<String, Integer>> print = print(format);

        humanData.entrySet().stream()
                .filter(el -> filter.test(el.getValue()))
                .forEach(el -> print.accept(el));



    }

    private static Consumer<Map.Entry<String, Integer>> print(String format) {
        if (format.equals("name")){
            return el -> System.out.println(el.getKey());
        } else if (format.equals("age")) {
            return el -> System.out.println(el.getValue());
        } else if (format.equals("name age")) {
            return el -> System.out.println(el.getKey() + " - " + el.getValue());
        }
        throw new RuntimeException("Bad condition");
    }

    private static Predicate<Integer> getFilter(String condition, int years) {
        if (condition.equals("older")){
            return x -> x >= years;
        }
        if (condition.equals("younger")){
            return x -> x <= years;
        }

        throw new RuntimeException ("Bad condition");
    }
}
