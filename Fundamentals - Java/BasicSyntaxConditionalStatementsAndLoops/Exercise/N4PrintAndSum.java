package BasicSyntaxConditionalStatementsAndLoops.Exercise;
import java.util.Scanner;
public class N4PrintAndSum {
    public  static void main(String[] args){
        Scanner scanner = new Scanner (System.in);

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = scanner.nextInt();
                int sum = 0;

        for(int i=numberOne;i <= numberTwo;i++){
            System.out.printf("%d " ,numberOne);
            sum+=numberOne;
            numberOne++;
        }
        System.out.println("");
        System.out.printf("Sum: %d", sum);

    }
}
