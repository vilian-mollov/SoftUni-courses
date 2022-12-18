package catHouse.entities.cat;

public class LonghairCat extends BaseCat {

    private static final int INITIAL_KILOGRAMS = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    protected void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    @Override
    public void eating() {
        this.kilograms += 3;
    }
}
