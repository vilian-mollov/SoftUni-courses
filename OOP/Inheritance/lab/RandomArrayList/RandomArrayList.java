package Inheritance.lab.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {

    public Object getRandomElementAndRemovesIt() {
        Random random = new Random();
        int index = random.nextInt(super.size() - 1);
        return remove(index);
    }
}
