package StreamsFilesAndDirectories.lab;

import java.io.*;

public class N9SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Cube cube = new Cube("water",5.5,5.5,5.5);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("cube.txt"));
        objectOutputStream.writeObject(cube);

        ObjectInputStream objectInputStream =new ObjectInputStream(new FileInputStream("cube.txt"));

        Cube cubeObject = (Cube) objectInputStream.readObject();

    }
    static class Cube implements Serializable {
        String color;
        double length;
        double height;
        double width;
        public Cube(String color,double length,double height,double width){
            this.color = color;
            this.length =length;
            this.height = height;
            this.width = width;
        }

    }
}
