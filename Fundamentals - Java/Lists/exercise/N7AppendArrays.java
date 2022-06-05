package List.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class N7AppendArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] inputOfArrays = scanner.nextLine().split("\\|");
        String[] separated = new String[inputOfArrays.length];
        for (int i = 0; i < inputOfArrays.length; i++) {
            separated[i]="";
        }

        boolean getToTheFirstNumber = false;
        for (int i = 0; i <inputOfArrays.length ; i++) {
            for (int j = 0; j < inputOfArrays[i].length(); j++) {
                switch (inputOfArrays[i].charAt(j)){
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case '0':
                    getToTheFirstNumber=true;
                    break;
                }
                if(!getToTheFirstNumber && inputOfArrays[i].charAt(j)==32){
                    separated[i]="";
                }else{
                    separated[i]=separated[i]+inputOfArrays[i].charAt(j);
                }
            }
            getToTheFirstNumber=false;
        }
        String numbers ="";
        for (int i = separated.length-1; i >= 0 ; i--) {
            if(i==separated.length-1){
                numbers+=separated[i];
            }else{
                numbers+=" "+separated[i];
            }

        }
        List<Integer> numbersReversed = Arrays.stream(numbers.split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        for (Integer integer : numbersReversed) {
            System.out.print(integer+" ");
        }

//        1 2 3 |4 5 6 |  7  8
//        7 | 4  5|1 0| 2 5 |3
    }
}
