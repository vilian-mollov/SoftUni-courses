package BasicSyntaxConditionalStatementsAndLoops.Exercise;
import java.util.Scanner;
public class N1Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int number = scanner.nextInt();

        if(number<= 2){
            System.out.println("baby");

        }else if (number <=13){
            System.out.println("child");
        }else if(number<= 19){
            System.out.println("teenager");
        }else if(number <= 65){
            System.out.println("adult");
        }else if(number>=66){
            System.out.println("elder");
        }



    }
}
