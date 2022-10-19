package Inheritance.exercise.Animals;

public class Animal {

    protected String name;
    protected int age;
    protected String gender;


    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    private void setName(String name) {
        if (name == null || name.length() <= 1) {
            throw new IllegalArgumentException("Name cannot be empty or one symbol!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative number!");
        }
        this.age = age;
    }

    protected void setGender(String gender) {
        String genderToUpper = gender.toUpperCase();
        if (genderToUpper.equals("MALE") || genderToUpper.equals("FEMALE")) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Not supported gender: " + gender);
        }
    }

    public String produceSound() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "%s %d %s\n" +
                "%s", this.getClass().getSimpleName(), this.name, this.age, this.gender, this.produceSound());
    }
}
