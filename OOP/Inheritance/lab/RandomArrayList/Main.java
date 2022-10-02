package Inheritance.lab.RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList list = new RandomArrayList();

        list.add(14);
        list.add(24);
        list.add(54);
        list.add(42);
        list.add(15);
        list.add(67);
        list.add(11);
        list.add(12);
        list.add(21);
        list.add(235);
        list.add(23);
        list.add(17);

        System.out.println(list.getRandomElementAndRemovesIt());
        System.out.println(list.getRandomElementAndRemovesIt());
        System.out.println(list.getRandomElementAndRemovesIt());
        System.out.println(list.getRandomElementAndRemovesIt());

    }
}
