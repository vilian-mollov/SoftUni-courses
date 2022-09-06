package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class N5BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] charArr = scanner.nextLine().toCharArray();

        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();

        boolean isBalanced = true;

        for (char c : charArr) {

            if (c == '(' || c == '[' || c == '{') {
                openingBrackets.push(c);
            } else {
                if (openingBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpeningBracket = openingBrackets.pop();
                if (c == '}' && lastOpeningBracket != '{') {
                    isBalanced = false;
                } else if (c == ')' && lastOpeningBracket != '(') {
                    isBalanced = false;
                } else if (c == ']' && lastOpeningBracket != '[') {
                    isBalanced = false;
                }

            }

        }

        if (openingBrackets.isEmpty() && isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}
