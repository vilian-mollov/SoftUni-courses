package preliminaryExam;

import java.util.Scanner;

public class N6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean nIscorect = false;
        boolean foundCombination = false;
        boolean nForthree = false;
        if(n % 3 == 0){
            nForthree=true;
        }
        if (n % 10 == 5) {
            nIscorect = true;
        }


        for (int a = 1; a <= 9; a++) {
            for (int b = 9; b >= a; b--) {
                for (int c = 0; c <= 9; c++) {
                    for (int d = 9; d >= 0; d--) {
                        if ((a * b * c * d) == (a + b + c + d) && nIscorect) {
                                        foundCombination = true;
                            System.out.println(a * 1000 + b * 100 + c * 10 + d);
                            continue;
                        }else if((a * b * c * d) / (a + b + c + d) == 3 && nForthree ){
                            foundCombination = true;
                            System.out.println(d * 1000 + c * 100 + b * 10 + a);
                            break;
                        }

                        if(foundCombination){
                            break;
                        }


                    }
                    if(foundCombination){
                        break;
                    }

                }
                if(foundCombination){
                    break;
                }
            }
            if(foundCombination){
                break;
            }
        }


        if (foundCombination) {
            //System.out.println(a * 1000 + b * 100 + c * 10 + d); //където  number е комбинацията abcd или комбинацията dcba);
        } else {
            System.out.println("Nothing found");
        }
    }
}
