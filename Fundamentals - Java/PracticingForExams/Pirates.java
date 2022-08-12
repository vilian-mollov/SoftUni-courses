package ExamTraining.random;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<Long>> citiesPopulationAndGoldMap = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            fillTheCitiesPopulationAndGoldMap(citiesPopulationAndGoldMap, input);
            input = scanner.nextLine();
        }

        String commandsInput = scanner.nextLine();

        while (!commandsInput.equals("End")) {
            String[] commandData = commandsInput.split("=>");
            String command = commandData[0];
            if (command.equals("Plunder")) {
                plunderCommandAction(commandData, citiesPopulationAndGoldMap);
            }
            if (command.equals("Prosper")) {
                posterCommandAction(citiesPopulationAndGoldMap, commandData);
            }

            commandsInput = scanner.nextLine();
        }

        if (citiesPopulationAndGoldMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            printAllTargetsLeft(citiesPopulationAndGoldMap);
        }
    }

    private static void printAllTargetsLeft(Map<String, List<Long>> citiesPopulationAndGoldMap) {
        int count = citiesPopulationAndGoldMap.size();
        System.out.println("Ahoy, Captain! There are " + count + " wealthy settlements to go to:");
        for (Map.Entry<String, List<Long>> entry : citiesPopulationAndGoldMap.entrySet()) {
            String town = entry.getKey();
            long people = entry.getValue().get(0);
            long gold = entry.getValue().get(1);
            System.out.println(town + " -> Population: " + people + " citizens, Gold: " + gold + " kg");
        }


    }

    private static void posterCommandAction(Map<String, List<Long>> citiesPopulationAndGoldMap, String[] commandData) {
        String town = commandData[1];
        int gold = Integer.parseInt(commandData[2]);
        if (gold < 0) {
            System.out.println("Gold added cannot be a negative number!");
            return;
        }
        long currentGold = citiesPopulationAndGoldMap.get(town).get(1);
        long currentPopulation = citiesPopulationAndGoldMap.get(town).get(0);
        citiesPopulationAndGoldMap.get(town).clear();
        citiesPopulationAndGoldMap.get(town).add(currentPopulation);
        citiesPopulationAndGoldMap.get(town).add(currentGold + gold);
        long totalGold = currentGold + gold;

        System.out.println(gold + " gold added to the city treasury. " + town + " now has " + totalGold + " gold.");


    }


    private static void plunderCommandAction(String[] commandData, Map<String, List<Long>> citiesPopulationAndGoldMap) {
        String town = commandData[1];
        int people = Integer.parseInt(commandData[2]);
        int gold = Integer.parseInt(commandData[3]);
        long currentPopulation = citiesPopulationAndGoldMap.get(town).get(0);
        long currentGold = citiesPopulationAndGoldMap.get(town).get(1);

        if (currentPopulation - people <= 0 || currentGold - gold <= 0) {
            long plunderedGold;
            long killedPeople;

            plunderedGold = calculatePlunderedGold(gold, currentGold);
            killedPeople = calculateKilledPeople(people, currentPopulation);

            System.out.println(town + " plundered! " + plunderedGold + " gold stolen, " + killedPeople + " citizens killed.");
            System.out.println(town + " has been wiped off the map!");

            citiesPopulationAndGoldMap.remove(town);

            return;
        }

        System.out.println(town + " plundered! " + gold + " gold stolen, " + people + " citizens killed.");
        currentPopulation -= people;
        currentGold -= gold;
        citiesPopulationAndGoldMap.get(town).clear();
        citiesPopulationAndGoldMap.get(town).add(currentPopulation);
        citiesPopulationAndGoldMap.get(town).add(currentGold);


    }

    private static long calculateKilledPeople(int people, long currentPopulation) {
        long killedPeople;
        if (currentPopulation > people) {
            killedPeople = people;
        } else {
            killedPeople = currentPopulation;
        }
        return killedPeople;
    }

    private static long calculatePlunderedGold(int gold, long currentGold) {
        long plunderedGold;
        if (currentGold > gold) {
            plunderedGold = gold;
        } else {
            plunderedGold = currentGold;
        }
        return plunderedGold;
    }

    private static void fillTheCitiesPopulationAndGoldMap(Map<String, List<Long>> citiesPopulationAndGoldMap, String input) {
        String[] data = input.split("\\|\\|");
        String city = data[0];
        long population = Integer.parseInt(data[1]);
        long gold = Integer.parseInt(data[2]);

        if (!citiesPopulationAndGoldMap.containsKey(city)) {
            citiesPopulationAndGoldMap.put(city, new ArrayList<>());
            citiesPopulationAndGoldMap.get(city).add(population);
            citiesPopulationAndGoldMap.get(city).add(gold);
        } else {
            long currentPopulation = citiesPopulationAndGoldMap.get(city).get(0) + population;
            long currentGold = citiesPopulationAndGoldMap.get(city).get(1) + gold;
            citiesPopulationAndGoldMap.get(city).clear();
            citiesPopulationAndGoldMap.get(city).add(currentPopulation);
            citiesPopulationAndGoldMap.get(city).add(currentGold);

        }


    }
}
