package ObjectsAndClasses.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N3OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> listOfPeople = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Person person = new Person(input[0],Integer.parseInt(input[1]));
            listOfPeople.add(person);
        }
            listOfPeople.stream().sorted((p1,p2)->p2.name.compareTo(p1.name)).filter(person -> person.age>30)
                    .forEach(System.out::println);


    }
    static class Person{
        String name;
        int age;
        Person(String name,int age){
            this.name=name;
            this.age=age;
        }
@Override
        public String toString(){
            return String.format("%s - %d",this.name,this.age);
}

    }


}
