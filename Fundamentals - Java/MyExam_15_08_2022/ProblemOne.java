package Exam;

import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String inputCommands = scanner.nextLine();

        while (!inputCommands.equals("Easter")){
            String[] commandsData = inputCommands.split("\\s+");
            String command = commandsData[0];
            switch(command){

                case "Replace":
                    char currentChar = commandsData[1].charAt(0);
                    char newCharToChange = commandsData[2].charAt(0);
                    char[] arr = text.toCharArray();
                    for (int i = 0; i < arr.length; i++) {
                        if(arr[i] == currentChar){
                            arr[i] = newCharToChange;
                        }
                    }
                    text = String.valueOf(arr);
                    System.out.println(text);
                    break;
                case "Remove":
                    String substringToRemove = commandsData[1];
                    text =  text.replaceFirst(substringToRemove,"");
                    System.out.println(text);
                    break;
                case "Includes":
                    String stringToInclude = commandsData[1];
                    if(text.contains(stringToInclude)){
                        System.out.println("True");
                    }else{
                        System.out.println("False");
                    }
                    break;
                case "Change":
                    String lowerOrUpper = commandsData[1];
                    if(lowerOrUpper.equals("Lower")){
                        text =text.toLowerCase();
                    }else{
                        text = text.toUpperCase();
                    }
                    System.out.println(text);
                    break;
                case "Reverse":
                    int start = Integer.parseInt(commandsData[1]);
                    int end = Integer.parseInt(commandsData[2]);
                    if(start >= 0 && start < text.length() && end >=0 && end <text.length()){
                        String substringToPrint = text.substring(start,end+1);
                        substringToPrint = new StringBuilder(substringToPrint).reverse().toString();
                        System.out.println(substringToPrint);
                    }
                    break;



            }



            inputCommands = scanner.nextLine();
        }


    }
}
