package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> listNumbers = Arrays.stream(scanner.nextLine().split(", ")).map(el -> Integer.parseInt(el)).collect(Collectors.toList());

        listNumbers.removeIf(num -> num % 2 != 0);

        extracted(listNumbers);

        List <Integer> sortNumbers = listNumbers.stream().sorted().collect(Collectors.toList());

        extracted(sortNumbers);


    }

    private static void extracted(List<Integer> sortNumbers) {
        for (int i = 0; i < sortNumbers.size(); i++) {

            if (i < sortNumbers.size() - 1){
                System.out.print(sortNumbers.get(i) + ", ");
            }else {
                System.out.println(sortNumbers.get(i));
            }
        }
    }


}
