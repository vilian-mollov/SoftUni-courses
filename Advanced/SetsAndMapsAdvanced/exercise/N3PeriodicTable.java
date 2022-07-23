package SetsAndMapsAdvanced.exercise;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class N3PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> elementsSet = new TreeSet<>();
        fillElementsSet(scanner, n, elementsSet);
        printElementsSet(elementsSet);

    }

    private static void printElementsSet(Set<String> elementsSet) {
        for (String s : elementsSet) {
            System.out.print(s+" ");
        }
    }

    private static void fillElementsSet(Scanner scanner, int n, Set<String> elementsSet) {
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (String s : elements) {
                elementsSet.add(s);
            }
        }
    }
}
