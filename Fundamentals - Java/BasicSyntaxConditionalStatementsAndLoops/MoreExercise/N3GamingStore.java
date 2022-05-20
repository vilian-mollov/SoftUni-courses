package BasicSyntaxConditionalStatementsAndLoops.MoreExercise;

import java.util.Scanner;

public class N3GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double fistMoney = balance;

        while(!input.equals("Game Time")){
            switch (input){
                case "OutFall 4":
                    if(balance>= 39.99){
                        balance-=39.99;
                        System.out.println("Bought OutFall 4");
                        if(balance==0.00){
                            System.out.println("Out of money!");
                            break;
                        }
                    }else{
                        System.out.println("Too Expensive");
                    }
                    break;
                case "CS: OG":
                    if(balance>= 15.99){
                        balance-=15.99;
                        System.out.println("Bought CS: OG");
                        if(balance==0.00){
                            System.out.println("Out of money!");
                            break;
                        }
                    }else{
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Zplinter Zell":
                    if(balance>= 19.99){
                        balance-=19.99;
                        System.out.println("Bought Zplinter Zell");
                        if(balance==0.00){
                            System.out.println("Out of money!");
                            break;
                        }
                    }else{
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Honored 2":
                    if(balance>= 59.99){
                        balance-=59.99;
                        System.out.println("Bought Honored 2");
                        if(balance==0.00){
                            System.out.println("Out of money!");
                            break;
                        }
                    }else{
                        System.out.println("Too Expensive");
                    }
                    break;
                case "RoverWatch":
                    if(balance>= 29.99){
                        balance-=29.99;
                        System.out.println("Bought RoverWatch");
                        if(balance==0.00){
                            System.out.println("Out of money!");
                            break;
                        }
                    }else{
                        System.out.println("Too Expensive");
                    }
                    break;
                case "RoverWatch Origins Edition":
                    if(balance>= 39.99){
                        balance-=39.99;
                        System.out.println("Bought RoverWatch Origins Edition ");
                        if(balance==0.00){
                            System.out.println("Out of money!");
                            break;
                        }
                    }else{
                        System.out.println("Too Expensive");
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }
            input = scanner.nextLine();
        }
if(balance!=0.0) {
    System.out.printf("Total spent: $%.2f. Remaining: $%.2f", fistMoney - balance, balance);
}
    }
}
