package Exam_22_October_2022.shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {

    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        Animal animal = null;
        boolean isFound = false;
        for (Animal a : data) {
            if (a.getName().equals(name)) {
                isFound = true;
                animal = a;
            }
        }
        data.remove(animal);
        return isFound;
    }

    public Animal getAnimal(String name, String caretaker) {

        for (Animal animal : data) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        Animal animal = null;
        int age = Integer.MIN_VALUE;
        for (Animal a : data) {
            if (a.getAge() > age) {
                animal = a;
                age = a.getAge();
            }
        }
        return animal;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder text = new StringBuilder("The shelter has the following animals:\n");
        for (Animal a : data) {
            text.append(String.format("%s %s%n", a.getName(), a.getCaretaker()));
        }
        return text.toString();

    }

}
