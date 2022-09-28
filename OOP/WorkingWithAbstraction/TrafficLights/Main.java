package WorkingWithAbstraction.TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> colors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List<TrafficLight> trafficLightsList = new ArrayList<>();
        for (int i = 0; i < colors.size(); i++) {
            TrafficLight trafficLight = new TrafficLight(Color.valueOf(colors.get(i).toUpperCase()));
            trafficLightsList.add(trafficLight);
        }

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < trafficLightsList.size(); j++) {
                trafficLightsList.get(j).changeColor();
                System.out.print(trafficLightsList.get(j).getColor() + " ");
            }
            System.out.println();
        }


    }
}
