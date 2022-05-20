package Arrays.Exercise;
import java.util.Arrays;
import java.util.Scanner;

public class N5TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayAsAString = scanner.nextLine().split(" ");
        int[] numbers = Arrays.stream(arrayAsAString)
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int i = 0; i < numbers.length; i++) {
            boolean isTrue = false;

            for (int j = i; j < numbers.length-1 ; j++) {
                if(numbers[i]>numbers[j+1]){
                    isTrue=true;
                }else {
                    isTrue=false;
                    break;
                }
            }
            if(isTrue) {
                System.out.print(numbers[i]+" ");
            }
        }




        System.out.print(numbers[numbers.length-1]);


    }
}
