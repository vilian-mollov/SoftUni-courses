package ConditionalStatementsAdvanced.lab;

import java.util.Scanner;

public class A11FruitShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String product =scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());


        switch (day){
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                day = "workday";
                break;
            case "Saturday":
            case "Sunday":
                day = "weekend";
                break;
            default:
                System.out.println("error");
break;
        }


            if(day.equals("workday")) {
                switch(product){
                case "banana":
                    System.out.printf("%.2f",2.50 * quantity);
                    break;
                case "apple":
                    System.out.printf("%.2f",1.20* quantity);
                    break;
                case "orange":
                    System.out.printf("%.2f",0.85* quantity);
                    break;
                case "grapefruit":
                    System.out.printf("%.2f",1.45* quantity);
                    break;
                case "kiwi":
                    System.out.printf("%.2f",2.70* quantity);
                    break;
                case "pineapple":
                    System.out.printf("%.2f",5.50* quantity);
                    break;
                case "grapes":
                    System.out.printf("%.2f",3.85* quantity);
                    break;
                    default:
                        System.out.println("error");
                        break;
            }

        }else if(day.equals("weekend")) {

                switch(product){
                    case "banana":
                        System.out.printf("%.2f",2.70* quantity);
                        break;
                    case "apple":
                        System.out.printf("%.2f",1.25* quantity);
                        break;
                    case "orange":
                        System.out.printf("%.2f",0.90* quantity);
                        break;
                    case "grapefruit":
                        System.out.printf("%.2f",1.60* quantity);
                        break;
                    case "kiwi":
                        System.out.printf("%.2f",3.00* quantity);
                        break;
                    case "pineapple":
                        System.out.printf("%.2f",5.60* quantity);
                        break;
                    case "grapes":
                        System.out.printf("%.2f",4.20* quantity);
                        break;
                    default:
                        System.out.println("error");
                        break;
                }

            }





    }
}
