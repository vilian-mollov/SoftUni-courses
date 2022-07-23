package SetsAndMapsAdvanced.lab;

import java.util.*;

public class N6ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, List<Double>>> shops = new TreeMap<>();

        while(!input.equals("Revision")){
            String[] data = input.split(", ");
            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            shops.putIfAbsent(shop,new LinkedHashMap<>());
            var productsMap = shops.get(shop);
            productsMap.putIfAbsent(product,new ArrayList<>());
            productsMap.get(product).add(price);
            input = scanner.nextLine();
        }

        for (var entry : shops.entrySet()) {
            System.out.println(entry.getKey()+"->");
            for (var productsEntry : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f\n",productsEntry.getKey(),productsEntry.getValue().get(0));
            }
        }

    }
}
