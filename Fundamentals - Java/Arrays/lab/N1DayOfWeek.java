package Arrays.lab;

import java.util.Scanner;

public class N1DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        n-=1;
if(n>6 || n<0){
    System.out.println("Invalid day!");
}else {
    String[] daysOfTheWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    String day = daysOfTheWeek[n];
    System.out.println(day);
}

    }
}
