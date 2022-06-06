package List.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class N8AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String commands = scanner.nextLine();
        while (!commands.equals("3:1")) {
            String[] commandsSplitted = commands.split("\\s+");

            switch(commandsSplitted[0]){
                case "merge":
                    int startIndexs = Math.max(Integer.parseInt(commandsSplitted[1]),0);
                    int endIndex = Math.min(Integer.parseInt(commandsSplitted[2]),data.size()-1);

                   List<String> secondList = new ArrayList<>();
                    for (int i = 0; i < data.size() ; i++) {
                        String concatenate ="";
                        if(i==startIndexs){ //dali e i<=endIndex ili i < endIndex
                            for (int j = startIndexs; j <=endIndex ; j++) {
                                concatenate+= data.get(j);

                            }
                            secondList.add(concatenate);
                            i=endIndex;
                            concatenate="";
                        }else{
                            secondList.add(data.get(i));

                        }
                    }
                    if (!secondList.isEmpty()) {
                        data=secondList;
                    }

                    break;
                case "divide":
                    secondList = new ArrayList<>();
                    int index = Integer.parseInt(commandsSplitted[1]);
                    int parts = Integer.parseInt(commandsSplitted[2]);
                    String element = data.get(index);
                    if (element.length() % parts == 0) {
                        int symbols = element.length() / parts;
                        // ab cd ef
                        for (int i = 0; i < parts; i++) {
                            //  add first element to result List
                            secondList.add(element.substring(0, symbols));
                            // remove first element from the string
                            element = element.substring(symbols);
                        }
                        data.remove(index);
                        data.addAll(index, secondList);

                    } else {
                        int symbols = element.length() / parts;
                        // { abcd, efgh, ijkl} -> divide 0 3 -> {a, b, cd, efgh, ijkl}
                        for (int i = 0; i < parts; i++) {
                            if (i == parts - 1) {
                                secondList.add(element);
                            } else {
                                //  add first element to result List
                                secondList.add(element.substring(0, symbols));
                                // remove first element from the string
                                element = element.substring(symbols);
                            }
                        }
                        data.remove(index);
                        data.addAll(index, secondList);
                    }
                    break;
            }

            commands = scanner.nextLine();
        }

        for (String datum : data) {
            System.out.print(datum+" ");
        }

    }


}
