package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class N4LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //               0   1  2   3  4   5  6  7  8   9   10 ;
        int[] numbers = {1 ,2 ,5 ,3, 5, 2, 4, 1}; //Integer.parseInt(scanner.nextLine()); //{3 ,14 ,5 ,12 ,15 ,7 ,8 ,9 ,11 ,10 ,1}; // {11 ,12 ,13 ,3 ,14 ,4 ,15 ,5 ,6 ,7 ,8 ,7 ,16, 9, 8};
        //               1  2   2  3   4   3  4  5  6   6   1 ;
        int counter = 0;
        int[] lisLength = new int[numbers.length];
        Arrays.fill(lisLength, 1);

        for (int currentIndex = 1; currentIndex < numbers.length; currentIndex++) {
            for (int prevIndex = 0; prevIndex < currentIndex; prevIndex++) {

                if (numbers[prevIndex] < numbers[currentIndex]) {
                    if (lisLength[prevIndex] + 1 > lisLength[currentIndex]) {
                        lisLength[currentIndex] = lisLength[prevIndex] + 1;
                        counter++;
                        // More
                    }
                }
            }
        }
// OK
        int greatestLengthIndex = 0;  // 8
        int greatestNumb = 0; //6 //Integer.MIN_VALUE;

        for (int i = 0; i < lisLength.length; i++) {

            if (greatestNumb < lisLength[i]) {
                greatestLengthIndex = i;
            }
            greatestNumb = Math.max(greatestNumb, lisLength[i]);
        }
//        System.out.println(greatestNumb);
//        System.out.println(greatestLengthIndex);

        //OK


        //Here
        int x = 0;
        int y = 0;
        int curent = 0;
        int[] arr = new int[greatestNumb];


        int h = greatestLengthIndex;
        boolean flag = false;
        boolean anutherFlag = false;
        for (int i = greatestLengthIndex; i > 0; i--) {  //???? maj e 6 toest greatestNumber
            if (i == greatestLengthIndex) {

                arr[0] = numbers[i];
                if (lisLength[i - 1] + 1 == lisLength[h]) {
                    arr[greatestNumb - 2] = numbers[i - 1];
                    flag = true;
                    anutherFlag = true;
                }

//                                                              arr[greatestNumb-2] = numbers[i-1];
//                                                               x = numbers[greatestLengthIndex-1];
                //                }else{
                //                     x=numbers[greatestLengthIndex];
                //                }

            } else {
                if (flag) {
                    h = i;
                }
                if (lisLength[i - 1] + 1 == lisLength[h]) {
                    if (anutherFlag) {
                        curent++;
                    }
                    curent++;
                    arr[curent] = numbers[i - 1];

                    flag = true;
                } else {
                    flag = false;

                }
            }

        }
// Print ARR
            for (int o : arr) {
                System.out.print(o + " ");
            }
//EndPrinting


            //End
//        for (int i = arr.length-1; i >=0 ; i--) {
//            System.out.print(arr[i]+" ");
//        }


//        for (int i = 0; i < lisLength.length; i++) {
//            System.out.print(lisLength[i]+ " ");
//
//        }
        }
    }
