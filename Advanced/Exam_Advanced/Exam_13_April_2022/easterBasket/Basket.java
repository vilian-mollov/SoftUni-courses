package Exam_13_April_2022.easterBasket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {

    private List<Egg> data;

    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        return this.data.removeIf(s -> s.getColor().equals(color));
    }

    public Egg getStrongestEgg() {
        Egg egg = null;
        int strength = Integer.MIN_VALUE;
        for (Egg e : data) {
            if (e.getStrength() > strength) {
                strength = e.getStrength();
                egg = e;
            }
        }
        return egg;
    }

    public Egg getEgg(String color) {
        for (Egg e : data) {
            if (e.getColor().equals(color)) {
                return e;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
//        StringBuilder text = new StringBuilder(material + " basket contains:" + System.lineSeparator());
//        for (Egg egg : data) {
//            text.append(egg.toString()+System.lineSeparator());
//        }
//        return text.toString();
        return this.material + " basket contains:" + System.lineSeparator() +
                        this.data.stream().map(Egg::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}
