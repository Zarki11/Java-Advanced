package FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensorOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int lowerBound = Integer.parseInt(input.split(" ")[0]);
        int upperBound = Integer.parseInt(input.split(" ")[1]);

        String oddOrEven = scanner.nextLine();

        Predicate <Integer> predicate =
                oddOrEven.equals("odd") ?
                        x -> x % 2 != 0 :
                        x -> x % 2 == 0;

        IntStream.rangeClosed(lowerBound, upperBound)
                .filter(el -> predicate.test(el))
                .forEach(el -> System.out.print(el + " "));


    }
}
