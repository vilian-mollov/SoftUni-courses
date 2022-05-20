package DataTypesAndVariables.Execise;

import java.util.Scanner;

public class N9SpiceMustFlow {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSpices = Integer.parseInt(scanner.nextLine());

int collector = 0;
int days = 0;
        while(numberOfSpices>= 100){
            collector += numberOfSpices;
            collector -= 26;


            numberOfSpices-=10;
            days++;
            if(numberOfSpices<100){

                if(collector>=26){
                    collector-=26;
                }else {
                    collector-=collector;
                }
                break;
            }

        }
        System.out.println(days);
        System.out.println(collector);

    }
}
