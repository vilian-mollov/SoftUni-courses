package List.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class N3MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();
        List<String> firstArr = new ArrayList<>(Arrays.asList(firstInput.split("\\s+")));
        List<String> secondArr = new ArrayList<>(Arrays.asList(secondInput.split("\\s+")));
        List<String> total = new ArrayList<>();

int firstSize = firstArr.size();
int secondSize = secondArr.size();

if(firstSize>secondSize) {
    for (int i = 0; i < firstArr.size(); i++) {
        total.add(firstArr.get(i));
        if (i >= secondArr.size()) {
            continue;
        }
        total.add(secondArr.get(i));
    }

}else if (secondSize>firstSize){
    for (int i = 0; i < secondArr.size(); i++) {
        if (i >= firstArr.size()) {
            total.add(secondArr.get(i));
            continue;
        }
        total.add(firstArr.get(i));
        total.add(secondArr.get(i));
    }

}else{
    for (int i = 0; i < firstArr.size(); i++) {
        total.add(firstArr.get(i));
        total.add(secondArr.get(i));
    }

}
        for (String s : total) {
            System.out.print(s+" ");
        }

    }
}
