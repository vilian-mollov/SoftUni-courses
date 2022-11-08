package InterfacesAndAbstraction.lab.BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> robotsAndCitizens = new ArrayList<>();

        String input = reader.readLine();
        while (!input.equals("End")) {

            Identifiable enteringUnit = getUnit(input);
            robotsAndCitizens.add(enteringUnit);

            input = reader.readLine();
        }

        String lastDigitOfFakeIDs = reader.readLine();

        List<Identifiable> detained = new ArrayList<>();

        for (Identifiable unit : robotsAndCitizens) {
            String id = unit.getId();
            boolean isFake = true;

            for (int i = 0; i < lastDigitOfFakeIDs.length(); i++) {
                char charOfKnownFakeIDs = lastDigitOfFakeIDs.charAt(lastDigitOfFakeIDs.length() - 1 - i);
                char unitIDChar = id.charAt(id.length() - 1 - i);

                if (charOfKnownFakeIDs != unitIDChar) {
                    isFake = false;
                }
            }
            if (isFake) {
                detained.add(unit);
            }
        }

        for (Identifiable detainedUnit : detained) {
            System.out.print(detainedUnit.getClass().getSimpleName() + " ");
            System.out.println(detainedUnit.getId());
        }


    }

    private static Identifiable getUnit(String input) {

        String[] data = input.split("\\s+");

        if (data.length == 2) {
            String model = data[0];
            String id = data[1];
            Identifiable robot = new Robot(model, id);
            return robot;

        } else if (data.length == 3) {
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String id = data[2];
            Identifiable citizen = new Citizen(name, age, id);
            return citizen;
        }

        throw new IllegalArgumentException("Invalid number of input statements.");
    }
}
