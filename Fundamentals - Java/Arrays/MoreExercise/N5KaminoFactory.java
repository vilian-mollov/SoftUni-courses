package Arrays.MoreExercise;

import java.util.Scanner;
import java.util.Arrays;

public class N5KaminoFactory {

    //FUBAR

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dnaLength = Integer.parseInt(scanner.nextLine()); //length of arrays
        String inputLine = scanner.nextLine();  //input line of array separated by one or more "!";

        int[] lisArray = new int[dnaLength];      // Array that represents longest-increasing sequence
        Arrays.fill(lisArray,1);      // fill the array with 0;
        int[] bestSequence = new int[dnaLength]; // best lisArray
        int[] bestArrDNA = new int[dnaLength];   // best Array of ones and zeros

        int higherNumber =-1; // this is the highest number in bestSequence-array;
        int currentHigherNumb = 0; // this is the highest number in lisArray

        int positionCurrent=0; // position of the highest number in lisArray
        int positionHigher=0; // position ot the highest number in bestSequence - array;



        int sumOfCurrentDNA =0; // sum of numbers in the current "dnaCurrentDigits" - array;
        int sumOfBestDNA =0; // sum of the numbers in the "bestArrDNA"-array ;

        int sequenceOfIndex=0; // number that represents the index of array count when the array is not better than the last one, and is not replacing it;
        int bestSequenceIndex=0; // Index of the best "bestSequence"-array;

        while(!inputLine.equals("Clone them!")){            //while not receive command "Clone them!" - test new arrays

            String[] dna = inputLine.split("!+");       // splits the array by !-one or more
            int[] dnaCurrentDigits = new int[dna.length];    // the array of current digits
            parseDNADigits(dna, dnaCurrentDigits);             //Method to add the digits from "dna[]" to "dnaCurrentDigits[]"
            Arrays.fill(lisArray,1);                    //fills the lisArray with 0;
            positionCurrent=0;      // refreshes the current position of the highest number in the array
            currentHigherNumb=0;    // refreshes the current highest number
            sumOfCurrentDNA=0;      // refreshes the sum of numbers in the current array



            for (int i = 0; i < dnaCurrentDigits.length-1; i++) {
                if(dnaCurrentDigits[i]==1&&dnaCurrentDigits[i]==dnaCurrentDigits[i+1]){
                    lisArray[i+1]+=lisArray[i];     //1 1 1 2 1
                    if(lisArray[i+1]>currentHigherNumb){
                        currentHigherNumb=lisArray[i+1];
                        positionCurrent=i+1;
                    }

                }
            }
            for (int i = 0; i < dnaCurrentDigits.length; i++) {
                sumOfCurrentDNA+=dnaCurrentDigits[i];
            }
            if(sumOfCurrentDNA==1 && dnaCurrentDigits[dnaCurrentDigits.length-1]==1){
                currentHigherNumb=1;
            }
            if(currentHigherNumb>higherNumber){
                higherNumber=currentHigherNumb;
                BestSequEqualToLisArray(lisArray, bestSequence);
                BestDNAEqualTo_dnaCurrentDigits(bestArrDNA, dnaCurrentDigits);
                positionHigher=positionCurrent;
                bestSequenceIndex += 1+sequenceOfIndex;
                sumOfBestDNA=sumOfCurrentDNA;

            }else if(currentHigherNumb==higherNumber){
                //проверка кой е на по предна позиция
                if(positionCurrent<positionHigher){
                    BestSequEqualToLisArray(lisArray, bestSequence);
                    BestDNAEqualTo_dnaCurrentDigits(bestArrDNA, dnaCurrentDigits);
                    positionHigher=positionCurrent;
                    bestSequenceIndex += 1+sequenceOfIndex;
                    sumOfBestDNA=sumOfCurrentDNA;
                }else if(positionCurrent == positionHigher){
                    if(sumOfCurrentDNA>sumOfBestDNA){
                        BestSequEqualToLisArray(lisArray, bestSequence);
                        BestDNAEqualTo_dnaCurrentDigits(bestArrDNA, dnaCurrentDigits);
                        bestSequenceIndex += 1+sequenceOfIndex;
                        sumOfBestDNA=sumOfCurrentDNA;
                    }
                }else{
                    sequenceOfIndex++;
                }
            }else{
                sequenceOfIndex++;
            }



            inputLine= scanner.nextLine();
        }


        System.out.printf("Best DNA sample %d with sum: %d.%n",bestSequenceIndex,sumOfBestDNA);
        for (int i : bestArrDNA) {
            System.out.print(i+" ");
        }

    }

    private static void BestDNAEqualTo_dnaCurrentDigits(int[] bestArrDNA, int[] dnaDigits) {
        for (int i = 0; i < dnaDigits.length; i++) {
            bestArrDNA[i]= dnaDigits[i];
        }
    }

    private static void BestSequEqualToLisArray(int[] counterArr, int[] bestSequence) {
        for (int i = 0; i < counterArr.length ; i++) {
            bestSequence[i] = counterArr[i];
        }
    }

    private static void parseDNADigits(String[] dna, int[] dnaDigits) {
        for (int i = 0; i < dnaDigits.length; i++) {
            dnaDigits[i] = Integer.parseInt(dna[i]);
        }
    }
}
