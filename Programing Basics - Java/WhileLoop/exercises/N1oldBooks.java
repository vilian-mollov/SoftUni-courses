package WhileLoop.exercises;

import java.util.Scanner;

public class N1oldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String searchedBook = scanner.nextLine();
        boolean itsFound = false;
        int counter = 0;


        String book = scanner.nextLine();
        while(!book.equals("No More Books")){

            if(book.equals(searchedBook)){
                itsFound = true;
                break;
            }
            counter++;

            book = scanner.nextLine();
        }
        if(itsFound){

            System.out.printf("You checked %d books and found it.",counter);

        }else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.",counter);

        }




    }
}
