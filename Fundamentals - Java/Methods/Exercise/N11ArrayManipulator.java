package Methods.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class N11ArrayManipulator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String initialArray = scanner.nextLine();
        List<Integer> arrayListOfNumbers = Arrays.stream(initialArray.split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandSplit = command.split(" ");
            switch (commandSplit[0]) {
                case "exchange":
                    exchangeArrays(arrayListOfNumbers, commandSplit);
                    break;
                case "max":
                    if(commandSplit[1].equals("even")){
                        findMaxEvenNumberIndex(arrayListOfNumbers);
                    }else{ //odd
                        findMaxOddNumberIndex(arrayListOfNumbers);
                    }
                    break;
                case "min":
                    if(commandSplit[1].equals("even")){
                        findMinEvenNumberIndex(arrayListOfNumbers);
                    }else{ //Odd
                        findMinOddNumberIndex(arrayListOfNumbers);
                    }
                    break;
                case "first":
                    if(commandSplit[2].equals("even")){
                        printEvenFirsNumber(arrayListOfNumbers, commandSplit);
                    }else{ //odd
                        printOddFirstNumbers(arrayListOfNumbers, commandSplit);
                    }
                    break;
                case "last":
                    if(commandSplit[2].equals("even")) {

                        printLastEvenNumbers(arrayListOfNumbers, commandSplit);

                    }else{ //odd
                        printLastOddNumbers(arrayListOfNumbers, commandSplit);
                    }
                    break;
            }


            command = scanner.nextLine();
        }

        System.out.println(arrayListOfNumbers);


    }

    private static void printLastOddNumbers(List<Integer> arrayListOfNumbers, String[] commandSplit) {
        if(Integer.parseInt(commandSplit[1]) > arrayListOfNumbers.size()){
            System.out.println("Invalid count");
        }else {
            int counter = 0;
            List<Integer> newArrayForFirstOdd = new ArrayList<>();
            for (int i = arrayListOfNumbers.size() - 1; i >= 0; i--) {
                if (arrayListOfNumbers.get(i) % 2 != 0 && counter < Integer.parseInt(commandSplit[1])) {
                        newArrayForFirstOdd.add(arrayListOfNumbers.get(i));
                        counter++;
                }
            }
            List<Integer> secondArray = new ArrayList<>();
            for (int i = newArrayForFirstOdd.size() - 1; i >= 0; i--) {
                secondArray.add(newArrayForFirstOdd.get(i));
            }
            System.out.println(secondArray);
        }
    }

    private static void printLastEvenNumbers(List<Integer> arrayListOfNumbers, String[] commandSplit) {
        if (Integer.parseInt(commandSplit[1]) > arrayListOfNumbers.size()) {
            System.out.println("Invalid count");
        }else{
        int counter = 0;
        List<Integer> newArrayForFirstEven = new ArrayList<>();
        for (int i = arrayListOfNumbers.size() - 1; i >= 0; i--) {
            if (arrayListOfNumbers.get(i) % 2 == 0 && counter < Integer.parseInt(commandSplit[1])) {
                    newArrayForFirstEven.add(arrayListOfNumbers.get(i));
                    counter++;
            }
        }
        List<Integer> secondArray = new ArrayList<>();
        for (int i = newArrayForFirstEven.size() - 1; i >= 0; i--) {
            secondArray.add(newArrayForFirstEven.get(i));
        }
        System.out.println(secondArray);
    }
    }

    private static void printOddFirstNumbers(List<Integer> arrayListOfNumbers, String[] commandSplit) {
        if(Integer.parseInt(commandSplit[1]) > arrayListOfNumbers.size()){
            System.out.println("Invalid count");
        }else {
            int counter = 0;
            List<Integer> newArrayForFirstOdd = new ArrayList<>();
            for (int i = 0; i < arrayListOfNumbers.size(); i++) {
                if (arrayListOfNumbers.get(i) % 2 != 0 && counter < Integer.parseInt(commandSplit[1])) {
                        newArrayForFirstOdd.add(arrayListOfNumbers.get(i));
                        counter++;
                }
            }
            System.out.println(newArrayForFirstOdd);
        }
    }

    private static void printEvenFirsNumber(List<Integer> arrayListOfNumbers, String[] commandSplit) {
        if(Integer.parseInt(commandSplit[1]) > arrayListOfNumbers.size()){
            System.out.println("Invalid count");
        }else {
            int counter = 0;
            List<Integer> newArrayForFirstEven = new ArrayList<>();
            for (int i = 0; i < arrayListOfNumbers.size(); i++) {
                if (arrayListOfNumbers.get(i) % 2 == 0 && counter < Integer.parseInt(commandSplit[1])) {
                        newArrayForFirstEven.add(arrayListOfNumbers.get(i));
                        counter++;
                }
            }
            System.out.println(newArrayForFirstEven);
        }
    }


    private static void findMinOddNumberIndex(List<Integer> arrayListOfNumbers) {
        int minIndexOdd =0;
        int minNumberOdd = Integer.MAX_VALUE;
        boolean hasMinOdd =false;
        for(int i = 0; i < arrayListOfNumbers.size(); i++){
            if(arrayListOfNumbers.get(i) <= minNumberOdd && arrayListOfNumbers.get(i) % 2 != 0){

                    minNumberOdd= arrayListOfNumbers.get(i);
                    minIndexOdd=i;
                    hasMinOdd=true;

            }
        }
        if(hasMinOdd){
            System.out.println(minIndexOdd);
        }else{
            System.out.println("No matches");
        }
    }

    private static void findMinEvenNumberIndex(List<Integer> arrayListOfNumbers) {
        int minIndex =0;
        int minNumber = Integer.MAX_VALUE;
        boolean hasMaxEven =false;
        for(int i = 0; i < arrayListOfNumbers.size(); i++){
            if(arrayListOfNumbers.get(i)<=minNumber && arrayListOfNumbers.get(i) % 2 == 0){
                    minNumber= arrayListOfNumbers.get(i);
                    minIndex=i;
                    hasMaxEven=true;
            }
        }
        if(hasMaxEven){
            System.out.println(minIndex);
        }else{
            System.out.println("No matches");
        }
    }

    private static void findMaxOddNumberIndex(List<Integer> arrayListOfNumbers) {
        int maxIndexOdd =0;
        int maxNumberOdd = Integer.MIN_VALUE;
        boolean hasMaxOdd =false;
        for(int i = 0; i < arrayListOfNumbers.size(); i++){
            if(arrayListOfNumbers.get(i) >= maxNumberOdd && arrayListOfNumbers.get(i) % 2 != 0){
                    maxNumberOdd= arrayListOfNumbers.get(i);
                    maxIndexOdd=i;
                    hasMaxOdd=true;
            }
        }
        if(hasMaxOdd){
            System.out.println(maxIndexOdd);
        }else{
            System.out.println("No matches");
        }
    }

    private static void findMaxEvenNumberIndex(List<Integer> arrayListOfNumbers) {
        int maxIndex =0;
        int maxNumber = Integer.MIN_VALUE;
        boolean hasMaxEven =false;
        for(int i = 0; i < arrayListOfNumbers.size(); i++){
            if(arrayListOfNumbers.get(i)>=maxNumber && arrayListOfNumbers.get(i) % 2 == 0){
                    maxNumber= arrayListOfNumbers.get(i);
                    maxIndex=i;
                    hasMaxEven=true;
            }
        }
        if(hasMaxEven){
            System.out.println(maxIndex);
        }else{
            System.out.println("No matches");
        }
    }

    private static void exchangeArrays(List<Integer> arrayListOfNumbers, String[] commandSplit) {
        if(Integer.parseInt(commandSplit[1])>=arrayListOfNumbers.size() || Integer.parseInt(commandSplit[1]) < 0){
            System.out.println("Invalid index");
            return;
        }
        int n = Integer.parseInt(commandSplit[1]);
        for (int i = 0; i <= n ; i++) {
            arrayListOfNumbers.add(arrayListOfNumbers.get(i));
        }
        for (int i = 0; i <= n; i++) {
            arrayListOfNumbers.remove(0);
        }
    }
}
