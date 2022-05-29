package List.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N3HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> partyList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            String[] inputSplited = input.split(" ");

            if (inputSplited[1].equals("is") && inputSplited[2].equals("going!")) {

                if (partyList.contains(inputSplited[0])) {
                    System.out.println(inputSplited[0] + " is already in the list!");

                } else {
                    partyList.add(inputSplited[0]);
                }
            }else if(inputSplited[1].equals("is") && inputSplited[2].equals("not")&& inputSplited[3].equals("going!")){
                if(partyList.contains(inputSplited[0])){
                    partyList.remove(inputSplited[0]);
                }else{
                    System.out.println(inputSplited[0]+" is not in the list!");
                }
            }

        }

        for (String s : partyList) {
            System.out.println(s);
        }

    }
}
