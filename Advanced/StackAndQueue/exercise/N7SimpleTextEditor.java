package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class N7SimpleTextEditor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // number of operations

        StringBuilder text = new StringBuilder(""); // current text
        ArrayDeque<String> cachedText = new ArrayDeque<>(); // cached text
        cachedText.push("");

        while (n-- > 0){
            String[] data = scanner.nextLine().split("\\s+"); // input of operations and data
            String operation = data[0];

            switch(operation){

                case "1": // append operation
                    String textToAdd =data[1];
                    text.append(textToAdd);
                    cachedText.push(text.toString());
                    break;
                case "2": // erase operation
                    int charsToRemove = Integer.parseInt(data[1]);
                    text = text.replace(text.length()-charsToRemove,text.length(),"");
                    cachedText.push(text.toString());
                    break;
                case "3": // print operation
                    int charToPrint = Integer.parseInt(data[1]);
                    System.out.println(text.toString().charAt(charToPrint-1));
                    break;
                case "4": // undo operation
                    cachedText.pop();
                    text.replace(0,text.length(),"");
                    text.append(cachedText.peek());
                    break;
            }

        }


    }
}
