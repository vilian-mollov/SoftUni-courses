package Polymorphism.exercise.WildFarm;

public abstract class Animal {

    protected String animalName;
    protected  String animalType;
    protected Double animalWeight;
    protected Integer foodEaten = 0;

    public abstract String makeSound();
    public abstract String eatFood(Food food);

}
