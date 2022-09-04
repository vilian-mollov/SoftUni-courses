package DefiningClasses.N1CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- >0){
            String[] data = scanner.nextLine().split("\\s+");
            String brand = data[0];
            String model = data[1];
           int horsepower = Integer.parseInt(data[2]);

           Car car = new Car();
           car.setBrand(brand);
           car.setModel(model);
           car.setHorsepower(horsepower);


            System.out.println(car.carInfo());
        }

    }
}
