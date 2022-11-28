package Polymorphism.exercise.WildFarm;

public class Tiger extends Felime {

    private static final Food ANIMAL_FOOD_TYPE = new Meat(0);

    public Tiger(String animalName, Double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
        this.animalType = "Tiger";
    }

    @Override
    public String makeSound() {
        return "ROAARRR!!!";
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
