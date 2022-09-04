package DefiningClasses.N3BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();


        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String command = data[0];

            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                int id = bankAccount.getId();
                bankAccounts.put(id,bankAccount);
                System.out.println("Account ID" + id + " created");
            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(data[1]);
                int amount = Integer.parseInt(data[2]);
                BankAccount bankAccount = bankAccounts.get(id);
                if (bankAccount != null) {
                    bankAccount.deposit(amount);
                    System.out.println("Deposited "+amount+" to ID"+id);
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(data[1]);
                BankAccount.setInterestRate(interest);
            } else {
                int id = Integer.parseInt(data[1]);
                int years = Integer.parseInt(data[2]);
                BankAccount bankAccount = bankAccounts.get(id);

                if (bankAccount != null) {
                    double interest = bankAccount.getInterest(years);
                    System.out.printf("%.2f%n",interest);
                } else {
                    System.out.println("Account does not exist");
                }

            }
            input = scanner.nextLine();
        }

    }


}


