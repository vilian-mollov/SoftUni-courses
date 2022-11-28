package Polymorphism.exercise.WildFarm;

public class Mouse extends Mammal{

    private static final Food ANIMAL_FOOD_TYPE = new Vegetable(0);

    public Mouse(String animalName, Double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
        this.animalType = "Mouse";
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    public String eatFood(Food food) {
        if (food.getClass() != ANIMAL_FOOD_TYPE.getClass()) {
            return this.getClass().getSimpleName() + " are not eating that type of food!";
        }

        this.foodEaten = food.getQuantity();
        return "Nom nom nom...";
    }
}
