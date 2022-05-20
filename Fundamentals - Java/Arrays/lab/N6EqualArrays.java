package Arrays.lab;

import java.util.Scanner;

public class N6EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputOne = scanner.nextLine();
        String inputTwo = scanner.nextLine();

        String[] arrayOne = inputOne.split("\\s+");
        String[] arrayTwo = inputTwo.split("\\s+");
        int length = Math.max(arrayOne.length,arrayTwo.length);
int collector =0;
boolean flag = true;
        for (int i = 0; i <= length-1 ; i++) {
            int one =Integer.parseInt(arrayOne[i]);
            int two =Integer.parseInt(arrayTwo[i]);
            if(one != two){
                System.out.printf("Arrays are not identical. Found difference at %d index.",i);
                flag=false;
                break;
            }else {
                collector+=one;
            }
        }
if(flag) {
    System.out.printf("Arrays are identical. Sum: %d", collector);
}

    }
}
