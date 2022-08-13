package PracticingForEXAM_10_04_2020;

import java.util.*;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> garageMap = new LinkedHashMap<>();

        addCarsToMyGarage(scanner, n, garageMap);

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] commandsDetail = input.split(" : ");
            String command = commandsDetail[0];
            String car = commandsDetail[1];

            switch (command) {

                case "Drive":
                    drivingMethod(garageMap, commandsDetail, car);
                    break;
                case "Refuel":
                    refillTheCar(commandsDetail, garageMap, car);
                    break;
                case "Revert":
                    reverseSomething(garageMap, commandsDetail, car);
                    break;
            }


            input = scanner.nextLine();
        }

        showMyGarage(garageMap);

    }

    private static void showMyGarage(Map<String, List<Integer>> garageMap) {
        if(!garageMap.isEmpty()){
            for (Map.Entry<String, List<Integer>> entry : garageMap.entrySet()) {
                int mileage = entry.getValue().get(0);
                int fuel = entry.getValue().get(1);
                System.out.println(entry.getKey()+" -> Mileage: "+mileage+" kms, Fuel in the tank: "+fuel+" lt.");
            }

        }
    }

    private static void reverseSomething(Map<String, List<Integer>> garageMap, String[] commandsDetail, String car) {
        int kilometersToRevert = Integer.parseInt(commandsDetail[2]);
        int mileage = garageMap.get(car).get(0);
        int fuel = garageMap.get(car).get(1);

        if (mileage - kilometersToRevert < 10000) {
            garageMap.get(car).clear();
            garageMap.get(car).add(10000);
            garageMap.get(car).add(fuel);
            return;
        }
        mileage -= kilometersToRevert;
        garageMap.get(car).clear();
        garageMap.get(car).add(mileage);
        garageMap.get(car).add(fuel);
        System.out.println(car + " mileage decreased by " + kilometersToRevert + " kilometers");

    }

    private static void refillTheCar(String[] commandsDetail, Map<String, List<Integer>> garageMap, String car) {
        int fuelToAdd = Integer.parseInt(commandsDetail[2]);
        int mileage = garageMap.get(car).get(0);
        int fuel = garageMap.get(car).get(1);

        if (fuelToAdd + fuel > 75) {
            int filledWith = 75 - fuel;
            fuel = 75;
            System.out.println(car + " refueled with " + filledWith + " liters");
        } else {
            fuel = fuel + fuelToAdd;
            System.out.println(car + " refueled with " + fuelToAdd + " liters");
        }

        garageMap.get(car).clear();
        garageMap.get(car).add(mileage);
        garageMap.get(car).add(fuel);


    }

    private static void drivingMethod(Map<String, List<Integer>> garageMap, String[] commandsDetail, String car) {
        int distance = Integer.parseInt(commandsDetail[2]);
        int neededFuel = Integer.parseInt(commandsDetail[3]);
        int mileage = garageMap.get(car).get(0);
        int fuel = garageMap.get(car).get(1);


        if (fuel < neededFuel) {
            System.out.println("Not enough fuel to make that ride");
            return;
        }

        mileage += distance;
        fuel -= neededFuel;
        System.out.println(car + " driven for " + distance + " kilometers. " + neededFuel + " liters of fuel consumed.");

        if (mileage >= 100000) {
            System.out.println("Time to sell the " + car + "!");
            garageMap.remove(car);
            return;
        }

        garageMap.get(car).clear();
        garageMap.get(car).add(mileage);
        garageMap.get(car).add(fuel);


    }

    private static void addCarsToMyGarage(Scanner scanner, int n, Map<String, List<Integer>> garageMap) {
        for (int i = 0; i < n; i++) {
            String inputCar = scanner.nextLine();
            String[] carDetails = inputCar.split("\\|");
            String model = carDetails[0];
            int mileage = Integer.parseInt(carDetails[1]);
            int fuel = Integer.parseInt(carDetails[2]);
            garageMap.put(model, new ArrayList<>());
            garageMap.get(model).add(mileage);
            garageMap.get(model).add(fuel);
        }
    }
}
