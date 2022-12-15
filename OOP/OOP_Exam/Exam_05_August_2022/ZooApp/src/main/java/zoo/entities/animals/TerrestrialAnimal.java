package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {

    private static final double INITIAL_KILOGRAMS = 5.50;
    private static final double INCREASE_KG_BY = 5.70;

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eat() {
        setKg(INCREASE_KG_BY);
    }
}
