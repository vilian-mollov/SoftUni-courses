package FunctionalProgramming;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class N5FilterByAge {

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = IntStream.range(0,n)
                .mapToObj(i -> readPerson(scanner))
                .collect(Collectors.toList());


        String condition = scanner.nextLine();
        int ageFilter = Integer.parseInt(scanner.nextLine());
        String outputFormat = scanner.nextLine();

        people = filteredByAgeCondition(people, getPredicate(condition, ageFilter));

        Consumer<Person> printer = getPrinter(outputFormat);

        people.forEach(printer);


    }

    private static Person readPerson(Scanner scanner) {
        String[] data = scanner.nextLine().split(", ");

        String name = data[0];
        int age = Integer.parseInt(data[1]);

        return new Person(name, age);
    }

    private static Consumer<Person> getPrinter(String outputPrintFormat) {
        switch (outputPrintFormat) {
            case "name":
                return p -> System.out.println(p.getName());
            case "age":
                return p -> System.out.println(p.getAge());
            case "name age":
                return p -> System.out.println(p.getName() +" - " + p.getAge());

            default:
                throw new IllegalArgumentException("Unknown format " + outputPrintFormat);

        }
    }

    public static Predicate<Person> getPredicate(String condition, int ageFilter) {
        switch (condition) {
            case "younger":
                return p -> p.getAge() <= ageFilter;

            case "older":
                return p -> p.getAge() >= ageFilter;

            default:
                throw new IllegalArgumentException("Invalid parameter for predicate " + condition + " " + ageFilter);
        }


    }


    public static List<Person> filteredByAgeCondition(List<Person> people, Predicate<Person> predicate) {
        return people.stream()
                .filter(predicate)
                .collect(Collectors.toList());

    }

}
