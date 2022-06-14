package ObjectsAndClasses.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N4Articles2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Article> listOfArticles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            Article article = new Article(input[0],input[1],input[2]);
            listOfArticles.add(article);
        }
        String secondInput = scanner.nextLine();
        for (Article list : listOfArticles) {
            System.out.println(list.toString());
        }


    }
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

        @Override
        public String toString() {
            return String.format("%s - %s: %s",this.title,this.content,this.author);
        }


    }
}
