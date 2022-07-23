package SetsAndMapsAdvanced.lab;

import java.util.*;

public class N7CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Map<String,List<String>>> world = new LinkedHashMap();

        int countOfLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countOfLines; i++) {
            String line = scanner.nextLine();
            String[] data = line.split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];
            world.putIfAbsent(continent,new LinkedHashMap<>());
            var countryWithCities = world.get(continent);
            countryWithCities.putIfAbsent(country,new ArrayList<>());
            List<String> cities = countryWithCities.get(country);
            cities.add(city);
            //world.put(continent,countryWithCities); - this should be unnecessary
        }
        //todo print the world!
        for (var continentsEntry : world.entrySet()) {
            System.out.println(continentsEntry.getKey()+":");
            for (Map.Entry<String, List<String>> countriesEntry : continentsEntry.getValue().entrySet()) {
                System.out.print("  "+countriesEntry.getKey()+" -> ");
                for(int i =0;i< countriesEntry.getValue().size();i++){
                    if(i==0){
                        System.out.print(countriesEntry.getValue().get(i));
                    }else{
                        System.out.print(", "+countriesEntry.getValue().get(i));
                    }
                }
                System.out.println();
            }

        }


    }
}
