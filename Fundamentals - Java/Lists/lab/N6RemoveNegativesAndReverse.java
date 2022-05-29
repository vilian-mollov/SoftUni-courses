package List.lab;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N6RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String input = scanner.nextLine();
       List<Integer> list = Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)<0){
                list.remove((Integer) list.get(i));
                i=-1;
            }
        }



        if(list.size()>0){
            for (int i = list.size()-1; i >=0 ; i--) {
                System.out.print(list.get(i)+" ");
            }

        }else {
            System.out.println("empty");
        }

    }
}
