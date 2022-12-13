package Exam_13_April_2022.easterBasket;

public class Main {
    public static void main(String[] args) {

        Basket basket = new Basket("asda", 11);
        Egg egg = new Egg("asd",9,"asdasd");
        basket.addEgg(null);
        basket.addEgg(egg);
        basket.addEgg(egg);
        basket.addEgg(egg);
        basket.addEgg(egg);
        basket.addEgg(egg);
        basket.addEgg(egg);
        basket.addEgg(egg);
        basket.addEgg(egg);
        basket.addEgg(egg);
        basket.addEgg(egg);
        basket.addEgg(egg);
        basket.addEgg(egg);
        basket.addEgg(egg);
        basket.addEgg(egg);

        System.out.println(basket.report());
    }
}
