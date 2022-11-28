package Polymorphism.exercise.WildFarm;

public abstract class Mammal  extends Animal{

    protected String livingRegion;

    @Override
    public String toString() {
        return String.format("%s [%s, %.2f, %s, %d]",this.getClass().getSimpleName(),animalName,animalWeight,livingRegion,foodEaten);
    }
}
