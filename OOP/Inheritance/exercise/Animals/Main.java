package Inheritance.exercise.Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String animalInput = reader.readLine();

        List<Animal> animals = new ArrayList<>();

        while (!animalInput.equals("Beast!")) {
            String nameAgeGenderInput = reader.readLine();

            Animal animal;
            animal = setAnimal(animalInput, nameAgeGenderInput);
            animals.add(animal);

            animalInput = reader.readLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }

        //Input:
        //Tomcat
        //Tom 12 Female
        //Dog
        //Rex 132 Male
        //Beast!

        //Output:
        //Tomcat
        //Tom 12 Male
        //MEOW
        //Dog
        //Rex 132 Male
        //Woof!


    }

    private static Animal setAnimal(String AnimalInput, String nameAgeGenderInput) {

        String[] arr = nameAgeGenderInput.split("\\s+");
        String name = arr[0];
        int age = Integer.parseInt(arr[1]);
        String gender = arr[2];

        String AnimalClass = AnimalInput.toUpperCase();
        switch (AnimalClass) {
            case "DOG":
                return new Dog(name, age, gender);
            case "CAT":
                return new Cat(name, age, gender);
            case "FROG":
                return new Frog(name, age, gender);
            case "KITTEN":
                return new Kitten(name, age, gender);
            case "TOMCAT":
                return new Tomcat(name, age, gender);
            default:
                throw new IllegalArgumentException("Not supported animal class: " + AnimalInput);
        }
    }
}
