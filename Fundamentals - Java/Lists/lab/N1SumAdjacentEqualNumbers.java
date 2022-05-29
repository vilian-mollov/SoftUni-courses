package List.lab;

import java.util.*;
import java.util.stream.Collectors;


public class N1SumAdjacentEqualNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Double> listNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toList());
        for (int i = 0; i < listNumbers.size() - 1; i++) {
            if (listNumbers.get(i).equals(listNumbers.get(i + 1))) {
                listNumbers.set(i, listNumbers.get(i) + listNumbers.get(i + 1));
                listNumbers.remove(i + 1);

                i = -1;
            }

        }
        for (Double listNumber : listNumbers) {
            if(listNumber%1==0){
             System.out.printf("%.0f ",listNumber);
           }else
               System.out.printf("%.1f ", listNumber);
        }




    }

}
