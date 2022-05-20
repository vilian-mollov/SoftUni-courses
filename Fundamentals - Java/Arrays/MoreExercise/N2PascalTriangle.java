package Arrays.MoreExercise;

import java.util.Scanner;

public class N2PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfColons =Integer.parseInt(scanner.nextLine());
        int[] arr = {0,1,0};

        for (int i = 0; i < numberOfColons; i++) {

            int[] arrPlusOne = new int[arr.length+1];
            arrPlusOne[0]=0;
            arrPlusOne[arrPlusOne.length-1]=0;

            for (int j = 0; j < i+1+1 ; j++) {
                if(j==i+1+1-1){

                }else {
                    System.out.print(arr[j + 1] + " ");
                }
                arrPlusOne[j+1]=arr[j]+arr[j+1];
            }
            System.out.println();
            arr = arrPlusOne;
        }


    }
}
