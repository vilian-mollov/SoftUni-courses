package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class N9ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rangeTo = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersToCompare = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BiPredicate<Integer,List<Integer>> testDivisibility = (num,lis) -> {
            boolean isValid = false;
            for (int i = 0; i < lis.size(); i++) {
                if(num % lis.get(i) == 0){
                    isValid = true;
                }else{
                    return false;
                }

            }
            return  isValid;
        };

        for (int i = 1; i <= rangeTo; i++) {

           String result = (testDivisibility.test(i,numbersToCompare))?    String.valueOf(i+" ") : "";
            System.out.print(result);

        }


    }
}
