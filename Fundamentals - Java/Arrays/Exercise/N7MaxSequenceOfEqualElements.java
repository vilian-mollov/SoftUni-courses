package Arrays.Exercise;

import java.util.Scanner;

public class N7MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbersAsStrings = scanner.nextLine().split("\\s+");
        int[] numbers = new int[numbersAsStrings.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsStrings[i]);
        }
        int[] misLength = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            misLength[i] = 1;
        } // - misLength - 1 1 1 1 1 1 1 1 1 1

        // 0 1 2 3 4 5 6 7 8 9
        // 2 1 1 2 3 3 2 2 2 1
        // 1 1 2 1 1 2 1 2 3 1

        for (int i = 0; i < numbers.length-1; i++) {
            if(numbers[i]==numbers[i+1]){
                misLength[i+1] = misLength[i]+1;
            }
        }


        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < misLength.length; i++) {
            if (misLength[i]>max) {
                max = misLength[i];
                maxIndex = i;
            }
        }
int[] indexes = new int[max];
        int maxCopy = max;
        for (int i = maxIndex; i >maxIndex-max; i--) {
            indexes[maxCopy-1]=i;
            maxCopy--;

        }
        for (int index : indexes) {
            System.out.print(numbers[index] + " ");
        }


    }
}
