package DataTypesAndVariables.MoreExercise;
import java.util.Scanner;
public class N3FloatingEquality {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner(System.in);
        double n = Double.parseDouble(scanner.nextLine());
        double z = Double.parseDouble(scanner.nextLine());


if(equals(n,z)){
    System.out.println("True");
}else{
    System.out.println("False");
}

    }
    private final static double EPSILON = 0.000001;


    /**
     * Returns true if two doubles are considered equal.  Tests if the absolute
     * difference between two doubles has a difference less then .00001.   This
     * should be fine when comparing prices, because prices have a precision of
     * .001.
     *
     * @param a double to compare.
     * @param b double to compare.
     * @return true true if two doubles are considered equal.
     */
    public static boolean equals(double a, double b){
        return a == b ? true : Math.abs(a - b) < EPSILON;
    }

}
