package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("//s+")).collect(Collectors.toList());

        Consumer <String> namesPrint;
        printNames(names);



    }

    private static void printNames(List<String> names) {

        names.stream().forEach(el -> System.out.println(el));

    }
}
