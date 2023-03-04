package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        Map <String, String> emails = new LinkedHashMap<>();

        while (!inputLine.equals("stop")){
            String email = scanner.nextLine();

            emails.put(inputLine, email);

            inputLine = scanner.nextLine();
        }
        emails.entrySet().removeIf(el -> el.getValue().endsWith("us") || el.getValue().endsWith("uk") ||
                el.getValue().endsWith("com"));

        emails.entrySet().forEach(el -> System.out.println(el.getKey() + " -> " + el.getValue()));


    }
}
