package TextProcessing.exercise;

import java.util.*;

public class N6ReplaceRepeatingChars {
    public static void main(String[] args) {
        //aaaaabbbbbcdddeeeedssaa
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        char[] data = n.toCharArray();
        List<Character> sequence = new ArrayList<>();
        sequence.add(data[0]);
        char holder =data[0];
        for (int i = 0; i < data.length; i++) {
            if(data[i] != holder) {
                sequence.add(data[i]);
                holder=data[i];
            }
        }
        for (Character character : sequence) {
            System.out.print(character);
        }


    }


}
