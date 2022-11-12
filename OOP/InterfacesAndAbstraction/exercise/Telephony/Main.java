package InterfacesAndAbstraction.exercise.Telephony;

public class Main {
    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone();

        System.out.println(smartphone.call("088 789 0000"));
        System.out.println(smartphone.call("359 88 789 0000"));
        System.out.println(smartphone.call("087 789 0000"));
        System.out.println(smartphone.call("35999 789 0000"));

        System.out.println(smartphone.browse("https://www.google.com/"));
        System.out.println(smartphone.browse("https://www.youtube.com/"));
        System.out.println(smartphone.browse("https://www.facebook.com/"));
    }
}
