package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate <String> predicate = el -> Character.isUpperCase(el.charAt(0));

        List <String> collect = Arrays.stream(scanner.nextLine().split(" ")).filter(word -> predicate.test(word)).collect(Collectors.toList());

        System.out.println(collect.size());

        collect.stream().forEach(el -> System.out.println(el));

    }
}
