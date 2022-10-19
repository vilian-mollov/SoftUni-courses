package Inheritance.exercise.Animals;

public class Kitten extends Cat {
    //Kittens are always female

    private static final String GENDER = "Female";

    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void setGender(String gender) {
        super.setGender(gender);
        this.gender = GENDER;
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
