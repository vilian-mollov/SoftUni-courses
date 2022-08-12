package ExamTraining.Final_09_08_2020;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String,List<Double>> plantsRarityMap = new LinkedHashMap<>();
        Map<String,List<Double>> keyPlantRatingMap = new LinkedHashMap<>();

        fillTheMaps(scanner, n, plantsRarityMap,keyPlantRatingMap);

        String input = scanner.nextLine();
        while (!input.equals("Exhibition")){
            String[] commandsData = input.split(": ");
            String command = commandsData[0];

            switch (command){

                case "Rate":
                    String[] data = commandsData[1].split(" - ");
                    addAGivenRatingToAPlant(data,keyPlantRatingMap);
                    break;
                case "Update":
                    String[] dataOne = commandsData[1].split(" - ");
                    updateTheRarityOfAPlant(dataOne,plantsRarityMap);
                    break;
                case "Reset":
                    String plant = commandsData[1];
                    keyPlantRatingMap.get(plant).clear();
                    break;
                default:
                    System.out.println("error");
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<Double>> entry : keyPlantRatingMap.entrySet()) {
            for (Double aDouble : entry.getValue()) {
                plantsRarityMap.get(entry.getKey()).add(aDouble);
            }

        }


        System.out.println("Plants for the exhibition:");

        for (Map.Entry<String, List<Double>> entry : plantsRarityMap.entrySet()) {
            System.out.printf("- %s; Rarity: %.0f; Rating: ",entry.getKey(),entry.getValue().get(0));
            double totalRating = 0.00;
            if(!entry.getValue().isEmpty()) {
                for (int i = 1; i < entry.getValue().size(); i++) {
                    totalRating += entry.getValue().get(i);
                }
            }
            if(entry.getValue().size()>1){
                totalRating /= entry.getValue().size()-1;
            }
            System.out.printf("%.2f%n",totalRating);
        }


    }

    private static void updateTheRarityOfAPlant(String[] dataOne, Map<String, List<Double>> plantsRarityMap) {
        String plant = dataOne[0];
        double newRarity = Double.parseDouble(dataOne[1]);

        if(!plantsRarityMap.containsKey(plant)){
            System.out.println("error");
            return;
        }

        plantsRarityMap.get(plant).clear();
        plantsRarityMap.get(plant).add(newRarity);

    }

    private static void addAGivenRatingToAPlant(String[] data, Map<String, List<Double>> keyPlantRatingMap) {
            String plant = data[0];
            double rating = Double.parseDouble(data[1]);

           if(!keyPlantRatingMap.containsKey(plant)){
               System.out.println("error");
               return;
           }

           keyPlantRatingMap.get(plant).add(rating);


    }

    private static void fillTheMaps(Scanner scanner, int n, Map<String, List<Double>> plantsRarityMap, Map<String,List<Double>> keyPlantRatingMap) {
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split("<->");
            String plant = data[0];
            double rarity = Double.parseDouble(data[1]);

            plantsRarityMap.putIfAbsent(plant,new ArrayList<>());
            plantsRarityMap.get(plant).add(rarity);

            keyPlantRatingMap.putIfAbsent(plant,new ArrayList<>());

        }
    }
}
