package Exam_19_February_2022.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable();
                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrots = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable();
                parrots.add(parrot);
            }
        }
        return parrots;
    }

    public int count() {
        return data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder(String.format("Parrots available at %s:%n",name));
        for (Parrot parrot : data) {
            if(parrot.isAvailable()){
                sb.append(String.format("%s%n",parrot.toString()));
            }
        }
        return sb.toString();
    }
}
