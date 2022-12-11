package Exam_18_August_2022;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Kat {
    private static ArrayDeque<BigInteger> licences;
    private static ArrayDeque<BigInteger> cars;
    private static int days;
    private static BigInteger carRegistered;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        days = 0;
        carRegistered = new BigInteger("0");
        licences = new ArrayDeque<>();
        cars = new ArrayDeque<>();
        licences = Arrays.stream(scanner.nextLine().split(", "))
                .map(BigInteger::new).
                collect(Collectors.toCollection(ArrayDeque::new));
        Arrays.stream(scanner.nextLine().split(", "))
                .map(BigInteger::new)
                .forEach(cars::push);


        while (!licences.isEmpty() && !cars.isEmpty()) {

            BigInteger licencePlatesForTheDay = licences.peek();
            BigInteger carsForTheDay = cars.peek();

            BigInteger carsThatCanPass = licencePlatesForTheDay.divide(BigInteger.TWO);

            if (carsThatCanPass.compareTo(carsForTheDay) > 0) {
                BigInteger leftPlates = new BigInteger("0");
                leftPlates = licencePlatesForTheDay.subtract(carsForTheDay.multiply(BigInteger.TWO));
                licences.poll();
                licences.add(leftPlates);
                cars.pop();
                carRegistered = carRegistered.add(carsForTheDay);

            } else if (carsThatCanPass.compareTo(carsForTheDay) == 0) {
                licences.poll();
                cars.pop();
                carRegistered = carRegistered.add(carsForTheDay);
//more logic needed here
            } else {
                BigInteger leftCars = new BigInteger("0");
                leftCars = carsForTheDay.subtract(carsThatCanPass);

                licences.poll();
                cars.pop();
                cars.add(leftCars);

                carRegistered = carRegistered.add(carsThatCanPass);
            }
            days++;
        }

        boolean everythingIsDone = false;
        if(cars.isEmpty() && licences.isEmpty()){ everythingIsDone = true;}
        System.out.printf("%s cars were registered for %d days!%n",carRegistered,days);
        if(everythingIsDone){
            System.out.println("Good job! There is no queue in front of the KAT!");
        }

        if(!licences.isEmpty()){
            BigInteger leftLicences = new BigInteger("0");
            while (!licences.isEmpty()){
                leftLicences = leftLicences.add(licences.poll());
            }
            System.out.printf("%s license plates remain!%n",leftLicences);
        }

        if(!cars.isEmpty()){
            BigInteger leftCars = new BigInteger("0");
            while (!cars.isEmpty()){
                leftCars = leftCars.add(cars.pop());
            }
            System.out.printf("%s cars remain without license plates!%n",leftCars);
        }


    }
}
