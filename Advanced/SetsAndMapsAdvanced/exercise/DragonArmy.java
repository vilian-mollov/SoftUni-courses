package SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {

    static class Dragon{
        String name;
        String color;
        int damage;
        int health;
        int armor;

        public Dragon(String color, String name, String damage, String health, String armor) {
            this.name = name;
            this.color = color;
            if(damage.equals("null")){
                this.damage = 45;
            }else {
                this.damage = Integer.parseInt(damage);
            }
            if(health.equals("null")){
                this.health = 250;
            }else {
                this.health = Integer.parseInt(health);
            }
            if(armor.equals("null")){
                this.armor = 10;
            }else {
                this.armor = Integer.parseInt(armor);
            }

        }

        public String getName() {
            return name;
        }

    }

    public static void main(String[] args) {


        Map<String, Map<String, Dragon>> dragons = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);


        byte n = Byte.parseByte(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String color = data[0];
            String name = data[1];
            String damage = data[2];
            String health = data[3];
            String armor = data[4];
            Dragon dragon = new Dragon(color,name,damage,health,armor);


            dragons.putIfAbsent(color, new TreeMap<>());

            dragons.get(color).put(name,dragon);
        }


        for (var entry : dragons.entrySet()) {
            System.out.print(entry.getKey() + "::");

            int count = entry.getValue().size();
            double avgHealth = 0.0;
            double avgDmg = 0.0;
            double avgArmor = 0.0;

            for (var dragonEntry : entry.getValue().entrySet()) {
                avgHealth += dragonEntry.getValue().health;
                avgArmor += dragonEntry.getValue().armor;
                avgDmg += dragonEntry.getValue().damage;
            }

            avgHealth /= count;
            avgDmg /= count;
            avgArmor /= count;

            System.out.printf("(%.2f/%.2f/%.2f)%n",avgDmg,avgHealth,avgArmor);

            for (var dragonEntry : entry.getValue().entrySet()) {
                Dragon d = dragonEntry.getValue();
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",d.name,d.damage,d.health,d.armor);
            }


        }



    }
}
