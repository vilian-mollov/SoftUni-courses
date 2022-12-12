package Exam_22_October_2022;

import java.util.*;
import java.util.stream.Collectors;

public class EnergyDrinks {
    private static ArrayDeque<Integer> miligramsOfCaffeine;
    private static ArrayDeque<Integer> energyDrinks;
    private static final int MAXIMUM_CAFFEINE_PER_NIGHT = 300;
    private static int initialCaffeine;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        miligramsOfCaffeine = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                .forEach(miligramsOfCaffeine::push);

        energyDrinks = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        initialCaffeine = 0;

        while (!miligramsOfCaffeine.isEmpty() && !energyDrinks.isEmpty()) {
            int theCaffeine = miligramsOfCaffeine.peek() * energyDrinks.peek();

            if (theCaffeine + initialCaffeine <= MAXIMUM_CAFFEINE_PER_NIGHT) {
                initialCaffeine += theCaffeine;
                miligramsOfCaffeine.pop();
                energyDrinks.poll();
            } else {
                int e = energyDrinks.poll();
                energyDrinks.add(e);
                miligramsOfCaffeine.pop();
                remove30caffeine();
            }
        }

        if (!energyDrinks.isEmpty()) {
            List<String> drinks = new ArrayList<>();
            while (!energyDrinks.isEmpty()){
                drinks.add(energyDrinks.poll().toString());
            }
            System.out.println("Drinks left: "+String.join(", ",drinks));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", initialCaffeine);

    }

    private static void remove30caffeine() {
        if (initialCaffeine <= 30) {
            initialCaffeine = 0;
        } else {
            initialCaffeine -= 30;
        }
    }
}
