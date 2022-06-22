package AssociativeArraysLambdaAndStreamAPI.exercise;

import java.util.*;

public class N3LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().toLowerCase();
        List<String> data = new ArrayList<>(Arrays.asList(line.split("\\s+")));
        int shadowmourne = 0;
        int valanyr = 0;
        int dragonwrath = 0;

        Map<String , Integer> inventory = new LinkedHashMap<>();
        inventory.put("shards",0);
        inventory.put("fragments",0);
        inventory.put("motes",0);
        boolean isFound = false;
        while (true) {
            data = new ArrayList<>(Arrays.asList(line.split("\\s+")));
            for (int i = 0; i < data.size()-1; i+=2) {
                if (!inventory.containsKey(data.get(i + 1))) {
                    inventory.put(data.get(i + 1), 0);
                }
                inventory.put(data.get(i + 1), inventory.get(data.get(i + 1)) + Integer.parseInt(data.get(i)));

                for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                    if (entry.getKey().equals("shards")&& entry.getValue()>shadowmourne) {
                        shadowmourne = entry.getValue();
                        if(shadowmourne >= 250){
                            System.out.println("Shadowmourne obtained!");
                            inventory.put("shards", inventory.get("shards") - 250);
                            inventory.putIfAbsent("shards", 0);
                            isFound=true;
                            break;
                        }

                    }else if (entry.getKey().equals("fragments")&& entry.getValue()>valanyr) {
                        valanyr = entry.getValue();
                        if(valanyr >= 250){
                            System.out.println("Valanyr obtained!");
                            inventory.put("fragments", inventory.get("fragments") - 250);
                            inventory.putIfAbsent("fragments", 0);
                            isFound=true;
                            break;
                        }
                    }else if (entry.getKey().equals("motes") && entry.getValue()>dragonwrath) {
                        dragonwrath = entry.getValue();
                        if(dragonwrath >= 250){
                            System.out.println("Dragonwrath obtained!");
                            inventory.put("motes", inventory.get("motes") - 250);
                            inventory.putIfAbsent("motes", 0);
                            isFound=true;
                            break;
                        }
                    }
                }
                if(isFound){
                    break;
                }
            }
            if (isFound) {
                break;
            }
            line = scanner.nextLine().toLowerCase();
        }

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

    }
}