package Inheritance.exercise.Animals;

public class Tomcat extends Cat {
//Tomcats are always males
    private static final String GENDER = "Male";

    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        super.setGender(gender);
        this.gender = GENDER;
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
