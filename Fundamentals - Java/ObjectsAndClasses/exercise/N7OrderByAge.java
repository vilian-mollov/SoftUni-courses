package ObjectsAndClasses.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N7OrderByAge {
    private static class Person{
        String name;
        String id;
        int age;
        Person(String name,String id, int age){
            this.name=name;
            this.id=id;
            this.age=age;
        }
        @Override
        public String toString(){
            return String.format("%s with ID: %s is %d years old.",this.name,this.id,this.age);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> listOfPeople = new ArrayList<>();

        while (!input.equals("End")){
            String[] data = input.split("\\s+");
            Person person = new Person(data[0],data[1],Integer.parseInt(data[2]));
            listOfPeople.add(person);

            input= scanner.nextLine();
        }
        listOfPeople.stream().sorted((p1,p2)-> Integer.compare(p1.age,p2.age))
                .forEach(System.out::println);


    }




}
