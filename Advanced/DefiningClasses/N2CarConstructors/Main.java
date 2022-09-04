package DefiningClasses.N2CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String brand = data[0];
            Car car;

            if (data.length == 1) {
                car = new Car(brand);
            } else {
                String model = data[1];
                int horsepower = Integer.parseInt(data[2]);
                car = new Car(brand, model, horsepower);
            }

            System.out.println(car.carInfo());
        }

    }
}
