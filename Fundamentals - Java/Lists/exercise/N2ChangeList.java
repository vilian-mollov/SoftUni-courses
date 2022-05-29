package List.exercise;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N2ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> listOfNumbers = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandSplited = command.split(" ");

            switch(commandSplited[0]){
                case "Delete":
                    Integer n = Integer.parseInt(commandSplited[1]);
                    for (int i = 0; i < listOfNumbers.size(); i++) {
                        if(listOfNumbers.get(i).equals(n)) {
                            listOfNumbers.remove(n);
                            i=-1;
                        }
                    }
                    break;
                case "Insert":
                    listOfNumbers.add(Integer.parseInt(commandSplited[2]),Integer.parseInt(commandSplited[1]));

                    break;

            }


            command = scanner.nextLine();
        }
        for (Integer listOfNumber : listOfNumbers) {
            System.out.print(listOfNumber+" ");
        }

    }
}
