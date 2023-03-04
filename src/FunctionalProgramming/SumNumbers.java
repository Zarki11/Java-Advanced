package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> parse = el -> Integer.parseInt(el);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(el -> parse.apply(el)).collect(Collectors.toList());

        System.out.print("Count = " + numbers.size());
        System.out.println();

        int sum = numbers.stream().mapToInt(a -> a).sum();

        System.out.println("Sum = " + sum);

    }
}
