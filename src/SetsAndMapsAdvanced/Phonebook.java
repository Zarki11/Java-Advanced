package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputInfo = scanner.nextLine();
        Map <String, String> phonebook = new LinkedHashMap<>();

        while (!inputInfo.equals("search")){
            String name = inputInfo.split("-")[0];
            String number = inputInfo.split("-")[1];

            phonebook.put(name, number);

            inputInfo = scanner.nextLine();
        }
        String toSearch = scanner.nextLine();

        while (!toSearch.equals("stop")) {
            if (phonebook.containsKey(toSearch)) {
                System.out.println(toSearch + " -> " + phonebook.get(toSearch));
            } else {
                System.out.printf("Contact %s does not exist.%n", toSearch);
            }
            toSearch = scanner.nextLine();
        }
    }
}
