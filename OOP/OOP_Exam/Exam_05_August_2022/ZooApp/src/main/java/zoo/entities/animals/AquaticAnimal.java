package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal{

    private static final double INITIAL_KILOGRAMS = 2.50;
    private static final double INCREASE_KG_BY = 7.50;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eat() {
        setKg(INCREASE_KG_BY);
    }
}
