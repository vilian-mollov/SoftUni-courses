package DataTypesAndVariables.MoreExercise;
import java.util.Scanner;
public class N5DecryptingMessage {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner(System.in);
        short key = Short.parseShort(scanner.nextLine());
        short n = Short.parseShort(scanner.nextLine());
        String singleChar ="";

        for (int i = 0; i <n ; i++) {
            singleChar = scanner.nextLine();
            char single = (char) (singleChar.charAt(0)+(char)key);

            System.out.print(single);
        }
    }
}
