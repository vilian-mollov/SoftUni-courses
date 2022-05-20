package DataTypesAndVariables.Execise;

import java.util.Scanner;

public class N3Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());

        int courses = (int) Math.ceil((double) n/p);
        System.out.println(courses);
//        int counter = n;
//        int counterOfRides = 0;
//        boolean counterOfBonusRides = false;
//        if (n <= p) {
//            System.out.println(1);
//        } else {
//            for (int i = 1; i <= n; i++) {
//                if(counter<p){
//                    counterOfBonusRides=true;
//                    break;
//                }
//                if (counter > p) {
//                    counter -= p;
//                    counterOfRides++;
//                }
//
//                if(counter<=0){
//                    break;
//                }
//
//            }
//            if(counterOfBonusRides) {
//                System.out.println(counterOfRides+1);
//            }else{
//                System.out.println(counterOfRides);
//            }
//        }
    }
}
