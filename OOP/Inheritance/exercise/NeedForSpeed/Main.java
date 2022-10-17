package Inheritance.exercise.NeedForSpeed;

public class Main {
    public static void main(String[] args) {
        System.out.print(System.lineSeparator());

        Vehicle vehicle = new Vehicle(50, 70);
        System.out.println("Vehicle");
        System.out.println("Starting fuel: " + vehicle.getFuel());
        vehicle.drive(20);
        System.out.println("Vehicle fuel after 20 kilometers: " + vehicle.getFuel());
        System.out.println("Fuel Consumption: " + vehicle.getFuelConsumption());

        System.out.print(System.lineSeparator());

        SportCar sportCar = new SportCar(272, 700);
        System.out.println("SportCar");
        System.out.println("Starting fuel: " + sportCar.getFuel());
        sportCar.drive(20);
        System.out.println("SportCar fuel after 20 kilometers: " + sportCar.getFuel());
        System.out.println("Fuel Consumption: " + sportCar.getFuelConsumption());

        System.out.print(System.lineSeparator());

        Car car = new Car(60, 60);
        System.out.println("Car");
        System.out.println("Starting fuel: " + car.getFuel());
        car.drive(20);
        System.out.println("Car fuel after 20 kilometers: " + car.getFuel());
        System.out.println("Fuel Consumption: " + car.getFuelConsumption());


    }
}
