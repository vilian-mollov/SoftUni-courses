package TextProcessing.lab;

import java.util.Scanner;

public class N3Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String toRemove = scanner.nextLine();
        String text = scanner.nextLine();
        int index = text.indexOf(toRemove);

        while(index>-1){
            String firstPart = text.substring(0,index);
            String secondPart = text.substring(index+toRemove.length());
            text=firstPart+secondPart;

            index = text.indexOf(toRemove);
        }
        System.out.println(text);

    }
}
