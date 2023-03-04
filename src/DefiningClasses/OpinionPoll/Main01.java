package DefiningClasses.OpinionPoll;

import java.util.*;
import java.util.stream.Collectors;

public class Main01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String humanData = scanner.nextLine();

            String name = humanData.split(" ")[0];
            int age = Integer.parseInt(humanData.split(" ")[1]);
            Person person = new Person(name, age);
            personList.add(person);
        }


        personList = personList.stream().filter(person -> person.getAge()> 30).collect(Collectors.toList());
        personList.sort(Comparator.comparing(person -> person.getName()));

        for (Person person:personList) {
            System.out.println(person.toString());
        }

    }
}
