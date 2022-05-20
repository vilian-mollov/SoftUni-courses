package WhileLoop.exercises;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wight = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int theCake = wight*length;
        boolean eaten = false;
        int counterOfPieces = 0;

String numberOfPiecesTaken = scanner.nextLine();

                    while(!numberOfPiecesTaken.equals("STOP")){
                       int numberOfPieces = Integer.parseInt(numberOfPiecesTaken);
                       counterOfPieces += numberOfPieces;

                       theCake -= numberOfPieces;

                        if(theCake <= 0){
                            eaten = true;
                            break;
                        }
                        numberOfPiecesTaken = scanner.nextLine();
                    }

                    if(eaten){
                        System.out.printf("No more cake left! You need %d pieces more.", Math.abs(theCake));
                    }else {
                        System.out.printf("%d pieces are left.",theCake);

                    }


    }
}
