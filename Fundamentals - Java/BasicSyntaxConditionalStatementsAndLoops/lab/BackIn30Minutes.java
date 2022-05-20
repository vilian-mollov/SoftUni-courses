package BasicSyntaxConditionalStatementsAndLoops.lab;
import java.util.Scanner;
public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = scanner.nextInt();

        minutes+=30;

        if(minutes>= 60){
            minutes -= 60;
            hours++;
        }
        if(hours > 23){
            hours=0;
        }

        System.out.printf("%d:%2d",hours, minutes);

    }
}
