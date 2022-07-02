package RegularExpressions.exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N1Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regEx = ">>(?<name>\\w+)<<(?<price>\\d+(.?\\d+)?)!(?<quantity>\\d+)";
        String furniture = scanner.nextLine();
        double total = 0;
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(furniture);
        List<String> names = new ArrayList<>();
        while(!furniture.equals("Purchase")){
            if(matcher.find()){
                String name = matcher.group("name");
                double  price= Double.parseDouble(matcher.group("price"));
                int quantity= Integer.parseInt(matcher.group("quantity"));
                total += price*quantity;
                names.add(name);
            }
            furniture = scanner.nextLine();
            matcher = pattern.matcher(furniture);
        }
        System.out.println("Bought furniture:");
        for (Object name : names) {
            System.out.println(name);
        }

        System.out.printf("Total money spend: %.2f",total);
    }
}
