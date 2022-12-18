package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{

    private static final int INITIAL_KILOGRAMS = 7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    protected void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    @Override
    public void eating() {
        this.kilograms ++;
    }
}
