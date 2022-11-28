package Polymorphism.exercise.WildFarm;

public class Cat extends Felime{
    private String breed;

    public Cat(String animalName, Double animalWeight, String livingRegion, String breed) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
        this.breed = breed;
        this.animalType = "Cat";
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public String eatFood(Food food) {
        this.foodEaten = food.getQuantity();
        return "Nom nom nom...";
    }

    @Override
    public String toString() {
        return String.format("Cat[%s, %s, %.2f, %s, %d]",animalName,breed,animalWeight,livingRegion,foodEaten);
    }
}
