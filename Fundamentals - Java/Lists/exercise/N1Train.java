package List.exercise;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N1Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> train = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxSpaceInWagon = Integer.parseInt(scanner.nextLine());

String command = scanner.nextLine();
        while(!command.equals("end")){
            String[] commandSplitted = command.split(" ");
            switch(commandSplitted[0]){
                case "Add":
                    train.add(Integer.parseInt(commandSplitted[1]));
                    break;
                default:
                    for (int i = 0; i < train.size(); i++) {
                        if(train.get(i)+Integer.parseInt(commandSplitted[0])<=maxSpaceInWagon){
                            train.set(i, train.get(i)+Integer.parseInt(commandSplitted[0]));
                            break;
                        }
                    }
            }


            command = scanner.nextLine();
        }
        for (Integer integer : train) {
            System.out.print(integer+" ");
        }


    }
}
