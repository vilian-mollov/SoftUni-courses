package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class N4LongestIncreasingSubsequence2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //               0   1  2   3  4   5  6  7  8   9   10 ;
        String input = scanner.nextLine();
        String[] stringNumb = input.split("\\s+");
        int[] numbers = new int[stringNumb.length]; //Integer.parseInt(scanner.nextLine()); //{3 ,14 ,5 ,12 ,15 ,7 ,8 ,9 ,11 ,10 ,1}; // {11 ,12 ,13 ,3 ,14 ,4 ,15 ,5 ,6 ,7 ,8 ,7 ,16, 9, 8};
        for (int i = 0; i< numbers.length;i++) {
            numbers[i] = Integer.parseInt(stringNumb[i]);
        }

        //               1  2   2  3   4   3  4  5  6   6   1 ;

        int[] lisLength = new int[numbers.length];
        Arrays.fill(lisLength, 1);
        int[] lisPrev = new int[numbers.length];
        Arrays.fill(lisPrev, -1);

        for (int currentIndex = 1; currentIndex < numbers.length; currentIndex++) {
            for (int prevIndex = 0; prevIndex < currentIndex; prevIndex++) {
                if (numbers[prevIndex] < numbers[currentIndex]) {
                    if (lisLength[prevIndex] + 1 > lisLength[currentIndex]) {
                        lisLength[currentIndex] = lisLength[prevIndex] + 1;
                        lisPrev[currentIndex] = prevIndex;
                        // More
                    }
                }
            }
        }
// OK
        int maxLengthIndex = 0;  // 8

        int greatestNumb = 0; //6 //Integer.MIN_VALUE;

        for (int i = 0; i < lisLength.length; i++) {

            if (greatestNumb < lisLength[i]) {
                maxLengthIndex = i;
            }
            greatestNumb = Math.max(greatestNumb, lisLength[i]);
        }

        int index = maxLengthIndex;
        int[] lis = new int[greatestNumb];
        int pos = 0;

        while(index != -1){
            lis[pos] = numbers[index];
            pos++;
            index = lisPrev[index];
        }

        for (int i =lis.length-1; i>=0;i--) {
            System.out.print(lis[i]+" ");
        }


    }
}
