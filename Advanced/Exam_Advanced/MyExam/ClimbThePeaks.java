package MyExam;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean viuhren = false;
        boolean kutelo = false;
        boolean banskiSuhodol = false;
        boolean polezhan = false;
        boolean kamenitza = false;


        ArrayDeque<Integer> food = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(food::push);

        ArrayDeque<Integer> stamina = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        List<String> mountains = new ArrayList<>();


        while (!food.isEmpty() && !stamina.isEmpty()) {

            int theSum = food.peek() + stamina.peek();

            if (!viuhren) {
                if (theSum >= 80) {
                    viuhren = true;
                    food.pop();
                    stamina.poll();
                    mountains.add("Vihren");
                } else {
                    food.pop();
                    stamina.poll();

                }
                continue;
            }
            if (!kutelo) {
                if (theSum >= 90) {
                    kutelo = true;
                    food.pop();
                    stamina.poll();
                    mountains.add("Kutelo");

                } else {
                    food.pop();
                    stamina.poll();
                }
                continue;
            }
            if (!banskiSuhodol) {
                if (theSum >= 100) {
                    banskiSuhodol = true;
                    food.pop();
                    stamina.poll();
                    mountains.add("Banski Suhodol");
                } else {
                    food.pop();
                    stamina.poll();
                }
                continue;
            }
            if (!polezhan) {
                if (theSum >= 60) {
                    polezhan = true;
                    food.pop();
                    stamina.poll();
                    mountains.add("Polezhan");
                } else {
                    food.pop();
                    stamina.poll();
                }
                continue;
            }
            if (theSum >= 70) {
                kamenitza = true;
                food.pop();
                stamina.poll();
                mountains.add("Kamenitza");
            } else {
                food.pop();
                stamina.poll();
            }

            if (kamenitza) {
                break;
            }
        }

        if (mountains.size() == 5) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (mountains.size() > 0) {
            System.out.println("Conquered peaks:");
            for (String mountain : mountains) {
                System.out.println(mountain);
            }
        }


    }
}
