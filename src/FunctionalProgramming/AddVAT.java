package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function <String, Double> parse = el -> Double.parseDouble(el);
        UnaryOperator <Double> VAT = el -> el * 1.2;

        List <Double> prices = Arrays.stream(scanner.nextLine().split(", "))
                .map(el -> parse.apply(el))
                .map(price -> VAT.apply(price)).collect(Collectors.toList());

        System.out.println("Prices with VAT:");
        prices.forEach(el -> System.out.printf("%.2f%n", el));

    }
}
