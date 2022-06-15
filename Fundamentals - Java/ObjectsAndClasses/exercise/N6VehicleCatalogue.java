package ObjectsAndClasses.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N6VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<Vehicle> listOfVehicles = new ArrayList<>();

        while (!command.equals("End")) {
            String[] vehicleData = command.split("\\s+");
            String type = vehicleData[0];
            String changed = "";
            changed = type.substring(0, 1).toUpperCase() + type.substring(1);
            Vehicle vehicle = new Vehicle(changed, vehicleData[1], vehicleData[2], Integer.parseInt(vehicleData[3]));
            listOfVehicles.add(vehicle);

            command = scanner.nextLine();
        }
        String line = scanner.nextLine();
        while(!line.equals("Close the Catalogue")) {
            String modelOne = line;
            listOfVehicles.stream().filter(vehicle1 -> vehicle1.getModel().equals(modelOne))
                    .forEach(System.out::print);
            line = scanner.nextLine();
        }
        //todo finish this task
        double totalHPOfCars = 0;
        int countOfCars=0;
        double totalHPOfTrucks = 0.0;
        int countOfTrucks=0;
        for (int i =0; i<listOfVehicles.size();i++) {
            if(listOfVehicles.get(i).getType().equals("Car")){
                totalHPOfCars+=listOfVehicles.get(i).getHorsePower();
                countOfCars++;
            }
        }
        for (int i =0; i<listOfVehicles.size();i++) {
            if(listOfVehicles.get(i).getType().equals("Truck")){
                totalHPOfTrucks+=listOfVehicles.get(i).getHorsePower();
                countOfTrucks++;
            }
        }
        if(countOfCars==0){
            System.out.println("Cars have average horsepower of: 0.00.");
        }else{
            System.out.printf("Cars have average horsepower of: %.2f.%n",totalHPOfCars/countOfCars);
        }

        if(countOfTrucks==0){
            System.out.println("Trucks have average horsepower of: 0.00.");
        }else{
            System.out.printf("Trucks have average horsepower of: %.2f.",totalHPOfTrucks/countOfTrucks);
        }

    }

    static class Vehicle {
        String type;
        String model;
        String color;
        int horsePower;

        Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }
        public String getType() {
            return type;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public String getModel() {
            return model;
        }

        @Override
        public String toString(){
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d%n",this.type,this.model,this.color,this.horsePower);
        }

    }
}
