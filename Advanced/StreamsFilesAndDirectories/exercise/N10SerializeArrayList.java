package StreamsFilesAndDirectories.exercise;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class N10SerializeArrayList {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        List<Double> doubleNumbers = Arrays.asList(34.4, 123.2, 12.22, 54.20, 120.120, 550.50);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("doubleList.ser"));
        oos.writeObject(doubleNumbers);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("doubleList.ser"));

        List<Double> newDoubleListSerialized = (List<Double>) ois.readObject();
        System.out.println(newDoubleListSerialized);

        ois.close();
    }
}
