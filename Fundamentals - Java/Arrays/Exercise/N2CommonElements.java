package Arrays.Exercise;


import java.util.*;

public class N2CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputOne = scanner.nextLine();
        String inputTwo = scanner.nextLine();
        String[] arrayOne = inputOne.split("\\s+");
        String[] arrayTwo = inputTwo.split("\\s+");


        for (int i = 0; i < arrayTwo.length; i++) {

            for (int j = 0; j < arrayOne.length; j++) {

                if(arrayTwo[i].equals(arrayOne[j])){
                    System.out.print(arrayOne[j]+" ");
                }
            }

        }

    }
}
