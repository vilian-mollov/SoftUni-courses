package Methods.Exercise;
import java.util.Scanner;
public class N6MiddleCharacters {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
String line = scanner.nextLine();
String[] splitLine = line.split("");

        getMiddleCharecters(splitLine);


    }

    private static void getMiddleCharecters(String[] splitLine) {
        if(splitLine.length%2 ==0){
            System.out.print(splitLine[splitLine.length/2-1]);
            System.out.print(splitLine[splitLine.length/2]);
        }else{
            System.out.print(splitLine[splitLine.length/2]);
        }
    }
}
