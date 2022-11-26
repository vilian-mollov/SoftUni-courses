package Polymorphism.exercise.Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //first line of input is about the car          - example: "Car 15 0.3"
        String[] carInfo = reader.readLine().split("\\s+");
        Double carFuel = Double.parseDouble(carInfo[1]);
        Double carLitersPerKm = Double.parseDouble(carInfo[2]);

        //second line of input is about the truck       - example: "Truck 100 0.9"
        String[] truckInfo = reader.readLine().split("\\s+");
        Double truckFuel = Double.parseDouble(truckInfo[1]);
        Double truckLitersPerKm = Double.parseDouble(truckInfo[2]);

        //third line of input is a Season               - one of four seasons
        String seasonName = reader.readLine().toUpperCase();
        Season season = Season.valueOf(seasonName);

        //Fourth line of input is number of commands    - simple integer number
        int n = Integer.parseInt(reader.readLine());

        //make car and truck objects with given info and add them into a map
        Vehicle car = new Car(carFuel,carLitersPerKm,season);
        Vehicle truck = new Truck(truckFuel,truckLitersPerKm,season);
        Map<String, Vehicle> vehicleMap = new HashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);


        //for loop to get all the commands from the console
        //command can be :
        //Drive Car {kilometers-(int)}
        //Drive Truck {kilometers-(int)}
        //Refuel Car {amount-(int)}
        //Refuel Truck {amount-(int)}
        for (int i = 0; i < n; i++) {
            String[] commandSplitted = reader.readLine().split("\\s+");

            String command = commandSplitted[0];
            String vehicleName = commandSplitted[1];
            Double amount = Double.parseDouble(commandSplitted[2]);
            Vehicle vehicle = vehicleMap.get(vehicleName);

            switch(command){
                case "Drive":
                    String driveResult = vehicle.drive(amount);
                    System.out.println(driveResult);
                    break;
                case "Refuel":
                    String refuelResult = vehicle.refuel(amount);
                    System.out.println(refuelResult);
                    break;
            }

        }

        System.out.println(System.lineSeparator());
        System.out.println(car);
        System.out.println();
        System.out.println(truck);

        //example input:
        //Car 30.4 0.4
        //Truck 99.34 0.9
        //SUMMER
        //5
        //Drive Car 500
        //Drive Car 13.5
        //Refuel Truck 10.300
        //Drive Truck 56.2
        //Refuel Car 100.2
        //


        //example output:
        //Car needs refueling!
        //Car travelled 13,50 km
        //Fuel added to truck tank: 10,30
        //Truck travelled 56,20 km
        //Fuel added to car tank: 100,20
        //
        //
        //Car: 113,05 liters in the tank
        //13,50 kilometers driven!
        //
        //Truck: 59,06 liters in the tank
        //56,20 kilometers driven!
        //
        //Process finished with exit code 0

    }
}
