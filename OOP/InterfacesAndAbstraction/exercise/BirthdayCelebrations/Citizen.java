package InterfacesAndAbstraction.exercise.BirthdayCelebrations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Citizen implements Person, Identifiable, Birthable {
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        setAge(age);
        setName(name);
        setId(id);
        setBirthDate(birthDate);
    }


    public void setName(String name) {
        String pattern = "^[A-Z][a-z]+$";
        boolean isValid = validate(pattern, name);

        if (!isValid) {
            throw new IllegalArgumentException("Name should have more than two letters," +
                    " and should start with capital letter!");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative number!");
        }
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setBirthDate(String birthDate) {
        String pattern = "^[0-9]{2}(?<symbols>[\\/.,])[0-9]{2}\\1[0-9]{4}$";
        boolean isValid = validate(pattern, birthDate);

        if (!isValid) {
            throw new IllegalArgumentException("The date format should be dd/mm/yyyy.\n" +
                    " Using '/' ',' or '.' as separation symbol");
        }
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    public void setId(String id) {
        String pattern = "^[0-9]+$";
        boolean isValid = validate(pattern, id);

        if (id.length() > 16 || !isValid) {
            throw new IllegalArgumentException("Invalid Id. ID should be less than 16 digits " +
                    "and should contains only digits.");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    private boolean validate(String pattern, String text) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(text);
        return matcher.find();
    }


}
