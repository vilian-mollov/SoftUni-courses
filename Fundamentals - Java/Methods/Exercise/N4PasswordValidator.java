package Methods.Exercise;

import java.util.Scanner;

public class N4PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String[] splitPass = password.split("");
int counterOfDigits=0;
boolean isWrongSymbol = false;
boolean isWrongLength = false;

        CheckIfPasswordIsValid(splitPass, counterOfDigits, isWrongSymbol, isWrongLength);

    }

    private static void CheckIfPasswordIsValid(String[] splitPass, int counterOfDigits, boolean isWrongSymbol, boolean isWrongLength) {
        if(splitPass.length<6 || splitPass.length>10){
            System.out.println("Password must be between 6 and 10 characters");
            isWrongLength =true;
        }

        for (int i = 0; i < splitPass.length ; i++) {
            int letter = splitPass[i].charAt(0);
            if(letter>=97 && letter<=122 || letter>=48 && letter<= 57 || letter>=65 && letter<=90){
                //correct symbol - letter or number
                if(letter>=48 && letter<= 57){
                    counterOfDigits++;
                }
            }else{
                isWrongSymbol =true;
                // wrong symbol
            }

        }
        if(isWrongSymbol){
            System.out.println("Password must consist only of letters and digits");
        }
        if(counterOfDigits <2){
            System.out.println("Password must have at least 2 digits");
        }
        if(counterOfDigits >=2 && !isWrongLength && !isWrongSymbol){
            System.out.println("Password is valid");
        }
    }
}
