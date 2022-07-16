package SetsAndMapsAdvanced.lab;
import java.util.*;

public class N1ParkingLot {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Set<String> parking = new LinkedHashSet<>();

    String input = scanner.nextLine();
    while(!input.equals("END")){
        String[] info = input.split(", ");
        String action = info[0];
        String carNumber = info[1];

        if(action.equals("IN")){
                parking.add(carNumber);
        }else{
            parking.remove(carNumber);
        }


        input = scanner.nextLine();
    }
        if(parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        if(!parking.isEmpty()) {
            for (String s : parking) {
                System.out.println(s);
            }
        }

    }
}
