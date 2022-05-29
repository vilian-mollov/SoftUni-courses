package List.exercise;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N4ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> listOfNumbers = Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String commands = scanner.nextLine();
        while (!commands.equals("End")) {
            String[] commandsSplitted = commands.split("\\s+");

            switch (commandsSplitted[0]) {
                case "Add":
                    listOfNumbers.add(Integer.parseInt(commandsSplitted[1]));
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandsSplitted[2]);
                    if(index>listOfNumbers.size() || index<0){
                        System.out.println("Invalid index");
                    }else{
                        listOfNumbers.add(index,Integer.parseInt(commandsSplitted[1]));
                    }
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(commandsSplitted[1]);
                    if(indexToRemove>listOfNumbers.size() || indexToRemove<0){
                        System.out.println("Invalid index");
                    }else{
                        listOfNumbers.remove(indexToRemove);
                    }
                    break;
                case "Shift":
                    if(commandsSplitted[1].equals("left")){
                        int n = Integer.parseInt(commandsSplitted[2]);
                        Integer hold = 0;
                        for (int i = 0; i < n ; i++) {
                            hold = listOfNumbers.get(0);
                            listOfNumbers.remove(0);
                            listOfNumbers.add(hold);
                        }

                    }else if(commandsSplitted[1].equals("right")){
                        int n = Integer.parseInt(commandsSplitted[2]);
                        Integer hold =0;
                        for (int i = listOfNumbers.size()-1; i >= listOfNumbers.size() - n ; i--) {
                            hold = listOfNumbers.get(listOfNumbers.size()-1);
                            listOfNumbers.remove(listOfNumbers.size()-1);
                            listOfNumbers.add(0,hold);
                        }

                    }
                    break;


            }


            commands = scanner.nextLine();
        }
        for (Integer listOfNumber : listOfNumbers) {
            System.out.print(listOfNumber+" ");
        }

    }
}
