package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class N1BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();
        String command = scanner.nextLine();


        String currentURL = "black";

        while (!command.equals("Home")) {
            currentURL=history.peek();
                if(command.equals("back")){
                    if(currentURL==null){
                        System.out.println("no previous URLs");
                    }else{
                        currentURL= history.pop();
                        if(history.isEmpty()){
                            System.out.println("no previous URLs");
                            history.push(currentURL);
                        }else{
                            System.out.println(history.peek());
                        }
                    }
                }else{
                    currentURL=command;
                    history.push(currentURL);
                    System.out.println(currentURL);
                }
            //todo implement logic
            command = scanner.nextLine();
        }
//        for (String s : history) {
//            System.out.println(s);
//        }


    }
}
