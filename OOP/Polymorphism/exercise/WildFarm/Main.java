package Polymorphism.exercise.WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String animalInfo = reader.readLine();
        String animalFoodInfo;

        List<Animal> farm = new ArrayList<>();

        while (!animalInfo.equals("End")) {

            animalFoodInfo = reader.readLine();

            String[] animalFoodAndQuantitySeparated = animalFoodInfo.split("\\s+");
            Food food = setFood(animalFoodAndQuantitySeparated);

            String[] animalDataSeparated = animalInfo.split("\\s+");
            Animal animal = getAnimal(animalDataSeparated);

            assert animal != null;
            String sound = animal.makeSound();
            System.out.println(sound);

            assert food != null;
            String eating = animal.eatFood(food);
            System.out.println(eating);

            farm.add(animal);

            animalInfo = reader.readLine();
        }


        for (Animal animal : farm) {
            System.out.println(animal);
        }

    }

    private static Animal getAnimal(String[] animalDataSeparated) {

        String animalType = animalDataSeparated[0];
        String animalName = animalDataSeparated[1];
        Double animalWeight = Double.parseDouble(animalDataSeparated[2]);
        String animalLivingRegion = animalDataSeparated[3];

        Animal animal = null;
        switch (animalType) {
            case "Cat":
                String catBreed = animalDataSeparated[4];
                animal = new Cat(animalName, animalWeight, animalLivingRegion, catBreed);
                break;
            case "Tiger":
                animal = new Tiger(animalName, animalWeight, animalLivingRegion);
                break;
            case "Mouse":
                animal = new Mouse(animalName, animalWeight, animalLivingRegion);
                break;
            case "Zebra":
                animal = new Zebra(animalName, animalWeight, animalLivingRegion);
                break;
        }
        return animal;
    }

    private static Food setFood(String[] animalFoodAndQuantitySeparated) {

        String foodType = animalFoodAndQuantitySeparated[0];
        int quantity = Integer.parseInt(animalFoodAndQuantitySeparated[1]);

        Food food = null;
        switch (foodType) {
            case "Vegetable":
                food = new Vegetable(quantity);
                break;
            case "Meat":
                food = new Meat(quantity);
                break;
        }
        return food;
    }
}
