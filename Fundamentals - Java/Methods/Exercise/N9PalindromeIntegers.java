package Methods.Exercise;
import java.util.Scanner;
public class N9PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String positiveInteger = scanner.nextLine();

        while (!positiveInteger.equals("END")){
            String[] numbersAsString = positiveInteger.split("");
           String firstHalf = "";
           String secondHalf = "";
            firstHalf = getFirstHalf(numbersAsString, firstHalf);
            if(numbersAsString.length % 2==0) {
                secondHalf = getSecondHalf(numbersAsString, secondHalf);
            }else{
                secondHalf = getSecondHalfIfIsOdd(numbersAsString, secondHalf);
            }

            String[] reversedFirstHalf = firstHalf.split("");
            reverseFirstString(reversedFirstHalf);

            String mirroredFirstHalf = "";
            mirroredFirstHalf = AddNumbersToMirroredFirstHalf(reversedFirstHalf, mirroredFirstHalf);

            System.out.println(mirroredFirstHalf.equals(secondHalf));

            positiveInteger = scanner.nextLine();
        }


    }

    private static String AddNumbersToMirroredFirstHalf(String[] reversedFirstHalf, String mirroredFirstHalf) {
        for (int i = 0; i < reversedFirstHalf.length; i++) {
            mirroredFirstHalf += reversedFirstHalf[i];
        }
        return mirroredFirstHalf;
    }

    private static void reverseFirstString(String[] reversedFirstHalf) {
        String holder;
        for (int i = 0; i < reversedFirstHalf.length/2; i++) {
            holder = reversedFirstHalf[i];
            reversedFirstHalf[i] = reversedFirstHalf[reversedFirstHalf.length-1-i];
            reversedFirstHalf[reversedFirstHalf.length-1-i] = holder;
        }
    }

    private static String getSecondHalfIfIsOdd(String[] numbersAsString, String secondHalf) {
        for (int i = numbersAsString.length / 2 +1; i < numbersAsString.length; i++) {
            secondHalf += numbersAsString[i];
        }
        return secondHalf;
    }

    private static String getSecondHalf(String[] numbersAsString, String secondHalf) {
        for (int i = numbersAsString.length / 2; i < numbersAsString.length; i++) {
            secondHalf += numbersAsString[i];
        }
        return secondHalf;
    }

    private static String getFirstHalf(String[] numbersAsString, String firstHalf) {
        for (int i = 0; i < numbersAsString.length/2; i++) {
            firstHalf += numbersAsString[i];
        }
        return firstHalf;
    }
}
