package Exam_18_August_2022.sanctuary;

public class Elephant {
    String name;
    int age;
    String retiredFrom;

    public Elephant(String name, int age, String retiredFrom) {
        this.name = name;
        this.age = age;
        this.retiredFrom = retiredFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRetiredFrom() {
        return retiredFrom;
    }

    public void setRetiredFrom(String retiredFrom) {
        this.retiredFrom = retiredFrom;
    }

    @Override
    public String toString() {
        return String.format("%s %d - %s",name,age,retiredFrom);
    }
}
