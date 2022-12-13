package Exam_13_April_2022;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    private static ArrayDeque<Integer> steel;
    private static ArrayDeque<Integer> carbon;
    private static Map<String, Integer> swords;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        steel = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        carbon = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(carbon::push);

        swords = new TreeMap<>();
        int numberOfSwords = 0;

        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int valueOfCarbonAndSteel = steel.peek() + carbon.peek();
            int swordValue;
            String swordName;
            switch (valueOfCarbonAndSteel) {

                case 70: // Gladius
                    swordName = "Gladius";
                    addSwordToCollection(swordName);
                    numberOfSwords++;
                    break;
                case 80: // Shamshir
                    swordName = "Shamshir";
                    addSwordToCollection(swordName);
                    numberOfSwords++;
                    break;
                case 90: // Katana
                    swordName = "Katana";
                    addSwordToCollection(swordName);
                    numberOfSwords++;
                    break;
                case 110: // Sabre
                    swordName = "Sabre";
                    addSwordToCollection(swordName);
                    numberOfSwords++;
                    break;
                default:
                    steel.poll();
                    int carbonValue = carbon.pop();
                    carbon.push(carbonValue + 5);
            }
        }

        if (numberOfSwords > 0) {
            System.out.println("You have forged " + numberOfSwords + " swords.");
        }else{
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if(steel.isEmpty()){
            System.out.println("Steel left: none");
        }else{
            printSteelLeft();
        }

        if(carbon.isEmpty()){
            System.out.println("Carbon left: none");
        }else{
            printCarbonLeft();
        }

        printSwordsAndTheirCountProduced();
    }

    private static void printSteelLeft() {
        System.out.print("Steel left: ");
        List<String> s = new ArrayList<>();
        while (!steel.isEmpty()){
            s.add(steel.poll().toString());
        }
        System.out.println(String.join(", ",s));
    }

    private static void printCarbonLeft() {
        System.out.print("Carbon left: ");
        List<String> s = new ArrayList<>();
        while (!carbon.isEmpty()){
            s.add(carbon.pop().toString());
        }
        System.out.println(String.join(", ",s));
    }

    private static void printSwordsAndTheirCountProduced() {
        for (Map.Entry<String, Integer> entry : swords.entrySet()) {
            System.out.println(entry.getKey()+": " + entry.getValue());
        }
    }

    private static void addSwordToCollection(String swordName) {
        int swordValue;
        swords.putIfAbsent(swordName, 0);
        swordValue = swords.get(swordName);
        swords.put(swordName, swordValue + 1);
        steel.poll();
        carbon.pop();
    }
}
