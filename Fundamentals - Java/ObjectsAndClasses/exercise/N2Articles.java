package ObjectsAndClasses.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class N2Articles {
    static class Article {
        String title;
        String content;
        String author;

        Article() {

        }

        Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        void edit(String content) {
            this.content = content;
        }

        void changeAuthor(String author) {
            this.author = author;
        }

        void rename(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s",this.title,this.content,this.author);
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> arrayInput = Arrays.asList(input.split(", "));
        int n = Integer.parseInt(scanner.nextLine());
        Article myObj = new Article(arrayInput.get(0),arrayInput.get(1),arrayInput.get(2));
        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split(": ");
            String theCommand = commands[0];
            switch (theCommand) {
                case "Edit":
                    String content = "";
                    for (int j = 1; j < commands.length; j++) {
                        if(j==1){
                            content+=commands[j];
                        }else{
                            content+=" "+commands[j];
                        }
                    }
                    myObj.edit(content);
                    break;
                case "ChangeAuthor":
                    String author = "";
                    for (int j = 1; j < commands.length; j++) {
                            author+=commands[j];

                    }
                    myObj.changeAuthor(author);
                    break;
                case "Rename":
                    String title = "";
                    for (int j = 1; j < commands.length; j++) {
                        if(j==1){
                            title+=commands[j];
                        }else{
                            title+=" "+commands[j];
                        }
                    }
                    myObj.rename(title);
                    break;
            }


        }
        System.out.println(myObj.toString());
    }
}
