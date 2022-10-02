package Encapsulation.exercise.ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] peopleAndMoney = reader.readLine().split(";");
        String[] productsAndCost = reader.readLine().split(";");

        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        addPeopleFromInputStream(peopleAndMoney, personList);
        addProductsFromInputStream(productsAndCost, productList);

        String input = reader.readLine();
        while (!input.equals("END")) {
            String[] personAndProduct = input.split("\\s+");
            String personName = personAndProduct[0];
            String productName = personAndProduct[1];

            Person person = getPersonFromList(personList, personName);
            Product product = getProductFromList(productList, productName);

            try {
                person.buyProduct(product);
                System.out.println(person.getName() + " bought " + product.getName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

            input = reader.readLine();
        }

        //print people products bought or Nothing bought
        for (Person person : personList) {
            System.out.print(person.getName() + " - ");

            if (person.getProducts().isEmpty()) {
                System.out.println("Nothing bought");

            } else {

                for (int i = 0; i < person.getProducts().size(); i++) {
                    Product product = person.getProducts().get(i);

                    if (i == person.getProducts().size() - 1) {
                        System.out.println(product.getName());

                    } else {
                        System.out.print(product.getName() + ", ");

                    }
                }
            }
        }

    }

    private static Person getPersonFromList(List<Person> personList, String personName) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getName().equals(personName)) {
                return personList.get(i);
            }
        }
        throw new RuntimeException("Non-existent Person");
    }

    private static Product getProductFromList(List<Product> productList, String productName) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(productName)) {
                return productList.get(i);
            }
        }
        throw new RuntimeException("Non-existent Product");
    }

    private static void addPeopleFromInputStream(String[] peopleAndMoney, List<Person> personList) {
        for (String string : peopleAndMoney) {
            String[] arr = string.split("=");
            String name = arr[0];
            double money = Double.parseDouble(arr[1]);
            Person person = new Person(name, money);
            personList.add(person);
        }
    }

    private static void addProductsFromInputStream(String[] productsAndCost, List<Product> productList) {
        for (String string : productsAndCost) {
            String[] arr = string.split("=");
            String name = arr[0];
            double cost = Double.parseDouble(arr[1]);
            Product product = new Product(name, cost);
            productList.add(product);
        }
    }
}
