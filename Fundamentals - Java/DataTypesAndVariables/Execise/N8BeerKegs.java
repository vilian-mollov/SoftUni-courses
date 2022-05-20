package DataTypesAndVariables.Execise;

import java.util.Scanner;

public class N8BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
int n = Integer.parseInt(scanner.nextLine());
        Double min=Double.MIN_VALUE;
        String theFinalKeg ="";


        for (int i = 1; i <=n ; i++) {
            String modelOfKeg = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            //formula - π * r^2 * h.
            if(Math. PI*(radius*radius)*height>min){
                theFinalKeg = modelOfKeg;
                min= Math. PI*(radius*radius)*height;
            }
        }

        System.out.println(theFinalKeg);
    }
}
