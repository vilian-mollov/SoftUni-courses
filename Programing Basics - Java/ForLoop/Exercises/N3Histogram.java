package ForLoop.Exercises;

import java.util.Scanner;

public class N3Histogram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;


        for (int i = 1; i <= count ; i++) {

            int number = Integer.parseInt(scanner.nextLine());


            if(number < 200){
                p1 += 1;

            }else if(number < 400){

                p2 += 1;

            }else if(number < 600){

                p3 += 1;

            }else if(number < 800){

                p4 += 1;
            }else {

                p5 += 1;

            }

        }


        System.out.printf("%.2f%% %n",p1 / count * 100);
        System.out.printf("%.2f%% %n",p2 / count * 100);
        System.out.printf("%.2f%% %n",p3 / count * 100);
        System.out.printf("%.2f%% %n",p4 / count * 100);
        System.out.printf("%.2f%% %n",p5 / count * 100);






    }
}
