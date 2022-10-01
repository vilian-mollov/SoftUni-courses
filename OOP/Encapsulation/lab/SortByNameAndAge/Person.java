package Encapsulation.lab.SortByNameAndAge;

public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;

    Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.", firstName, lastName, age);
    }
}
