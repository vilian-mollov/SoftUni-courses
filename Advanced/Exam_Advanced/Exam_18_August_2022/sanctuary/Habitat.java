package Exam_18_August_2022.sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {

    List<Elephant> data;
    int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        Elephant elephant = null;
        boolean isFound = false;
        for (Elephant e : data) {
            if (e.getName().equals(name)) {
                isFound = true;
                elephant = e;
            }
        }
        data.remove(elephant);
        return isFound;
    }

    public Elephant getElephant(String retiredFrom) {
        Elephant elephant = null;
        for (Elephant e : data) {
            if (e.getRetiredFrom().equals(retiredFrom)) {
                elephant = e;
            }
        }
        return elephant;
    }

    public Elephant getOldestElephant(){
        Elephant elephant = null;
        int age = Integer.MIN_VALUE;
        for (Elephant e : data) {
            if(e.getAge() > age){
                elephant = e;
                age = e.getAge();
            }
        }
        return elephant;
    }

    public int getAllElephants(){
       return data.size();
    }

    public String getReport(){
        String text = "Saved elephants in the park:\n";
        for (Elephant e : data) {
            text += String.format("%s came from: %s%n",e.getName(),e.getRetiredFrom());
        }
        return text;
    }
}
