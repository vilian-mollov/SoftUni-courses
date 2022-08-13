package StreamsFilesAndDirectories.exercise;

import java.io.*;

public class N11SerializePlayerObject {
    public static class Player implements Serializable {
        String name = "Thrall";
        String race = "Orc";
        String playerClass = "Warrior";
        int health = 100;
        int lvl = 69;
        int power = 700;
        int mana = 80;

        @Override
        public String toString() {
            return String.format("Player called " + this.name + " has " + this.health + " health and " + this.mana + " mana." + System.lineSeparator() +
                    "Details: \n" +
                    "Race: " + race + "\n" +
                    "Class: " + playerClass+"\n" +
                    "Lvl: "+ lvl+"\n" +
                    "Power: "+power);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Player player = new Player();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("player.ser"));
        oos.writeObject(player);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("player.ser"));

        Player newPlayer = (Player) ois.readObject();
        System.out.println(newPlayer.toString());
        ois.close();

    }
}
