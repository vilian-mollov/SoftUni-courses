package DefiningClasses.exercise.N4OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1]));
            people.add(person);
        }

        people.stream()
                .filter(person -> person.getAge() >30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

    }
}
