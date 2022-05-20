import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
// програма която изчислява необходимата сума за озеленяването
        //един кв. м. е 7.61 лв със ДДС
//18% отстъпка от крайната цена.
//От конзолата се прочита само един ред: Кв. метри, които ще бъдат озеленени – реално число в интервала [0.00 … 10000.00]

        Scanner scanner = new Scanner(System.in);
        double kmgreened = Double.parseDouble(scanner.nextLine());
        double price = kmgreened * 7.61;
        double discount = price * 0.18;
        double finalPrice = price - discount;
        System.out.println("The final price is: " + finalPrice + " lv.");
        System.out.println("The discount is: "+ discount +" lv.");



    }
}
