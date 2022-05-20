package Arrays.Exercise;

import java.util.Scanner;

public class N4ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int numberOfRotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfRotations; i++) {

            String holder = s[0];
            for (int j = 0; j < s.length -1; j++) {

                s[j]= s[j+1];

            }
            s[s.length-1]=holder;

        }
        System.out.println(String.join(" " , s));

    }
}

