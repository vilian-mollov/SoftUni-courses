package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class N6LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        String inputInitialFields = scanner.nextLine();
        String[] ladybugsIndexesString = inputInitialFields.split(" ");
        int[] ladybugsIndexes= new int[ladybugsIndexesString.length];
        parseLadyBugIndexesToInt(ladybugsIndexesString, ladybugsIndexes);

        int[] theField = new int[fieldSize];
        int[] theFieldIndexes = new int[theField.length];
        for (int i = 0; i < theField.length; i++) {
            theFieldIndexes[i] =i;
        }

        for (int i = 0; i < ladybugsIndexes.length; i++) {
            if(ladybugsIndexes[i]==theFieldIndexes[i]){
                theField[theFieldIndexes[i]]= ladybugsIndexes[i];
            }
        }
boolean itFoundsItsPlace = false;

        String inputLine = scanner.nextLine();
        while(!inputLine.equals("end")){
            String[] separator = inputLine.split(" ");
            int indexOfBug = Integer.parseInt(separator[0]);
            int flightOfBug = Integer.parseInt(separator[2]);
            String direction = separator[1];
            if(indexOfBug<= theField.length-1 && indexOfBug>=0) {
                switch (direction) {
                    case "right":
                        if(indexOfBug+flightOfBug > theField.length-1){
                            theField[indexOfBug] = 0;
                            break;
                        }
                        if(theField[indexOfBug+flightOfBug]==0){
                            theField[indexOfBug+flightOfBug]=theField[indexOfBug];
                            theField[indexOfBug] = 0;
                            itFoundsItsPlace=true;
                        }else{
                            if(indexOfBug + flightOfBug < theField.length) {
                                for (int i = indexOfBug + flightOfBug; i < theField.length; i+=flightOfBug) {
                                    if(i> theField.length-1){
                                        theField[indexOfBug] = 0;
                                        itFoundsItsPlace=true;
                                        break;
                                    }
                                    if(theField[i]==0){
                                        theField[i]=theField[indexOfBug];
                                        theField[indexOfBug] = 0;
                                        itFoundsItsPlace=true;
                                    }

                                }
                                if(itFoundsItsPlace){
                                    theField[indexOfBug] = 0;
                                }
                            }else{
                                theField[indexOfBug] = 0;
                            }
                        }
                        break;

                    case "left":
                        if(indexOfBug+flightOfBug > theField.length-1){
                            theField[indexOfBug] = 0;
                            break;
                        }
                        if(theField[indexOfBug+flightOfBug]==0){
                            theField[indexOfBug+flightOfBug]=theField[indexOfBug];
                            theField[indexOfBug] = 0;
                            itFoundsItsPlace=true;
                        }else{
                            if(indexOfBug + flightOfBug < theField.length) {
                                for (int i = indexOfBug + flightOfBug; i < theField.length; i+=flightOfBug) {
                                    if(i> theField.length-1){
                                        theField[indexOfBug] = 0;
                                        itFoundsItsPlace=true;
                                        break;
                                    }
                                    if(theField[i]==0){
                                        theField[i]=theField[indexOfBug];
                                        theField[indexOfBug] = 0;
                                        itFoundsItsPlace=true;
                                    }

                                }
                                if(itFoundsItsPlace){
                                    theField[indexOfBug] = 0;
                                }
                            }else{
                                theField[indexOfBug] = 0;
                            }
                        }

                        break;
                }
            }
        inputLine= scanner.nextLine();
        }
// Вземи по-добре я напиши на ново :) хахах! Впрочем , тука трябва да се оправи с преместването на ляво,
// както и да се помисли когато ти се вкара отрицателна стоиност от ляво, да местиш надясно и обратното. От дясно като ти се вкара
// отрицателна стойност да местиш наляво.
// Другот е , че много if проверки станаха и са много една в друга , ама не мога да се сетя за сега за по добър вариянт.
// Може да се напише на ново и да се помисли повече.
        for (int i : theField) {
            System.out.print(i+" ");
        }

    }

    private static void parseLadyBugIndexesToInt(String[] ladybugsIndexesString, int[] ladybugsIndexes) {
        for (int i = 0; i < ladybugsIndexes.length; i++) {
            ladybugsIndexes[i] = Integer.parseInt(ladybugsIndexesString[i]);
        }
    }

}
